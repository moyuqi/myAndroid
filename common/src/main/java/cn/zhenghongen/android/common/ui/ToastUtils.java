package cn.zhenghongen.android.common.ui;

import android.content.Context;
import android.widget.Toast;

import cn.zhenghongen.android.common.Application;


/**
 * Created by ZhengHongEn on 2015/11/2.
 */
public class ToastUtils {
    private static Context mcontext;

    public static void init(Context context) {
        mcontext = context;
    }

    public static void shortToast(String text) {
        Toast.makeText(mcontext, text, Toast.LENGTH_SHORT).show();
    }


    public static void shortToast(int resid) {
        Toast.makeText(mcontext, resid, Toast.LENGTH_SHORT).show();
    }


    public static void longToast(String text) {
        Toast.makeText(mcontext, text, Toast.LENGTH_LONG).show();
    }

    public static void longToast(int resid) {
        Toast.makeText(mcontext, resid, Toast.LENGTH_LONG).show();
    }
}
