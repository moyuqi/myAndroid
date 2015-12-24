package cn.zhenghongen.android.app.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.zhenghongen.android.app.R;
import cn.zhenghongen.android.common.ui.ToastUtils;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        ((Button)this.findViewById(R.id.btn_shortToast)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.shortToast("This is Short Toast");
            }
        });
    }

    public static void start(Context context){
        Intent intent = new Intent(context,ToastActivity.class);
        context.startActivity(intent);
    }
}
