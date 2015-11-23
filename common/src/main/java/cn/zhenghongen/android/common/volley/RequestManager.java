package cn.zhenghongen.android.common.volley;

import android.app.ActivityManager;
import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by ZhengHongEn on 2015/11/19.
 */
public class RequestManager {
    private static final String TAG = "VolleyRequestManger";

    private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoader;

    private RequestManager() {
        // no instances
    }

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);

        int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        // Use 1/8th of the available memory for this memory cache.
        int cacheSize = 1024 * 1024 * memClass / 8;
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(cacheSize));
    }

    public static void addRequest(Request<?> request) {
        addRequest(request, TAG);
    }

    public static void addRequest(Request<?> request, Object tag) {
        VolleyLog.wtf("Add Request to Queue: %s", request.getUrl());
        // set the default tag if tag is empty
        request.setTag(tag == null ? TAG : tag);
        //Setting Request Timeout
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        getRequestQueue().add(request);
    }

    public static void cancelAll() {
        cancelAll(TAG);
    }

    public static void cancelAll(Object tag) {
        if (tag == null) {
            tag = TAG;
        }
        getRequestQueue().cancelAll(tag);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }

    /**
     * Returns instance of ImageLoader initialized with {@see FakeImageCache}
     * which effectively means that no memory caching is used. This is useful
     * for images that you know that will be show only once.
     *
     * @return
     */
    public static ImageLoader getImageLoader() {
        if (mImageLoader != null) {
            return mImageLoader;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
