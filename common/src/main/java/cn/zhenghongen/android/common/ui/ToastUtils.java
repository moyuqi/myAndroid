package cn.zhenghongen.android.common.ui;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by ZhengHongEn on 2015/11/2.
 */
public class ToastUtils {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static void shortToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }


    public static void shortToast(int resid) {
        Toast.makeText(mContext, resid, Toast.LENGTH_SHORT).show();
    }


    public static void longToast(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
    }

    public static void longToast(int resid) {
        Toast.makeText(mContext, resid, Toast.LENGTH_LONG).show();
    }
}
