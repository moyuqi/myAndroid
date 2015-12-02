package cn.zhenghongen.android.common.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhengHongEn on 2015/12/2.
 */
public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

}
