package cn.zhenghongen.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import cn.zhenghongen.android.common.ui.ToastUtils;
import cn.zhenghongen.android.common.volley.RequestManager;

/**
 * Created by ZhengHongEn on 2015/10/29.
 */
public abstract class Application extends android.app.Application {
    private static final String TAG = "Application";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        //init
        ToastUtils.init(context);
        RequestManager.init(context);
    }

    public static Context getContext() {
        return context;
    }

    /**
     * 获取app版本号
     * 也可以通过BuildConfig.VERSION_NAME 获取
     *
     * @return
     */
    public static String getAppVersionName() {
        String appVersion = "1.0";
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionName; //版本名
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }

    /**
     * 获取app版本号
     * 也可以通过BuildConfig.VERSION_NAME 获取
     *
     * @return
     */
    public static int getAppVersionCode() {
        int appVersion = 1;
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionCode; //版本名
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }
}
