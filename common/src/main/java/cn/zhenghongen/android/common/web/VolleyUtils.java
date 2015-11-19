package cn.zhenghongen.android.common.web;

import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import cn.zhenghongen.android.common.Application;

/**
 * Created by ZhengHongEn on 2015/11/16.
 * 参考 http://blog.sina.com.cn/s/blog_5033827f0102uy0w.html
 */
public class VolleyUtils {
    private static VolleyUtils ourInstance = new VolleyUtils();
    private static final String TAG = "VolleyUtils";
    private RequestQueue mQueue;

    public static VolleyUtils getInstance() {
        return ourInstance;
    }

    private VolleyUtils() {

    }

    public void addToRequestQueue(Request request) {
        this.addToRequestQueue(request, TAG);
    }

    /**
     * 添加请求
     *
     * @param request
     * @param tag
     */
    public void addToRequestQueue(Request request, String tag) {
        VolleyLog.wtf("Add Request to Queue: %s", request.getUrl());
        // set the default tag if tag is empty
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        //Setting Request Timeout
        request.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));

        this.getQueue().add(request);
    }

    /**
     * 取消请求
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (this.getQueue() != null) {
            this.getQueue().cancelAll(tag);
        }
    }

    public RequestQueue getQueue() {
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(Application.getContext());
        }
        return mQueue;
    }

}
