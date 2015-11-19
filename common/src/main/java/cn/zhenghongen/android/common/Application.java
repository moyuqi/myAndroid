package cn.zhenghongen.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by ZhengHongEn on 2015/10/29.
 */
public class Application extends android.app.Application {
    private static final String TAG = "Application";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
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
    public static String getAppVersion() {
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
}
