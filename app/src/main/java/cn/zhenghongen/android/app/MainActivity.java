package cn.zhenghongen.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.zhenghongen.android.app.activity.singleFragmentActivity.DemoActivity;
import cn.zhenghongen.android.app.ui.ToastActivity;
import cn.zhenghongen.android.app.widget.PopupWindowActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_single_fragment://单Fragment
                DemoActivity.start(activity);
                break;
            case R.id.btn_toast://Toast
                ToastActivity.start(activity);
                break;
            case R.id.btn_popup_window://PopupWindow
                PopupWindowActivity.start(activity);
                break;
            default:
                break;
        }
    }
}
