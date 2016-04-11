package cn.zhenghongen.android.app.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zhenghongen.android.app.R;
import cn.zhenghongen.android.common.ui.ToastUtils;
import cn.zhenghongen.android.common.widget.OperationPopupWindow;

public class PopupWindowActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, PopupWindowActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                final List<Map<String, Object>> dataList = getData();
                AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Map<String, Object> data = dataList.get(position);
                        ToastUtils.longToast((String) data.get("text"));
                    }
                };

                OperationPopupWindow popupWindow = new OperationPopupWindow(this, "操作如下",
                        dataList, itemClickListener);
                popupWindow.showAtLocation(
                        this.findViewById(R.id.main_container), Gravity.BOTTOM
                                | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
                break;
            default:
                break;
        }
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map map = new HashMap<>();
            map.put("text", "操作1");
            dataList.add(map);
        }
        return dataList;
    }
}
