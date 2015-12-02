package cn.zhenghongen.android.app.Activity.SingleFragmentActivity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.zhenghongen.android.app.R;
import cn.zhenghongen.android.common.activity.SingleFragmentActivity;

/**
 * 注意事项：
 * 1.onCreate如果setContentView的话，layout里要添加FrameLayout，并且id一定是fragmentContainer；
 *   onCreate如果不setContentView的话，会调用默认的layout
 * 2.要实现 createFragment 方法
 */
public class DemoActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity_demo);
    }

    @Override
    protected Fragment createFragment() {
        return new SingleFragment();
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,DemoActivity.class);
        context.startActivity(intent);
    }
}
