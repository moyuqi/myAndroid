package cn.zhenghongen.android.common.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ZhengHongEn on 2015/12/2.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
        ActivityCollector.removeActivity(this);
    }
}
