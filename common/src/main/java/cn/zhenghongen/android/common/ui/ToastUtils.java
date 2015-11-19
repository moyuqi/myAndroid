package cn.zhenghongen.android.common.ui;

import android.widget.Toast;

import cn.zhenghongen.android.common.Application;


/**
 * Created by ZhengHongEn on 2015/11/2.
 */
public class ToastUtils {
    public static void shortToast(String text) {
        Toast.makeText(Application.getContext(), text, Toast.LENGTH_SHORT).show();
    }


    public static void shortToast(int resid) {
        Toast.makeText(Application.getContext(), resid, Toast.LENGTH_SHORT).show();
    }


    public static void longToast(String text) {
        Toast.makeText(Application.getContext(), text, Toast.LENGTH_LONG).show();
    }

    public static void longToast(int resid) {
        Toast.makeText(Application.getContext(), resid, Toast.LENGTH_LONG).show();
    }

}
