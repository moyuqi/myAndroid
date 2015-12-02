package cn.zhenghongen.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.zhenghongen.android.app.Activity.SingleFragmentActivity.DemoActivity;

public class MainActivity extends AppCompatActivity {
    protected Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;

        //单Fragment
        ((Button) this.findViewById(R.id.btn_single_fragment)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemoActivity.actionStart(activity);
            }
        });
    }
}
