package cn.zhenghongen.android.common.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import cn.zhenghongen.android.common.R;

/**
 * Created by ZhengHongEn on 2016/4/11.
 */
public class OperationPopupWindow extends PopupWindow {
    private View mMainView;
    private TextView mTitle;
    private ListView mListView;
    private TextView mCancle;

    public OperationPopupWindow() {

    }

    public OperationPopupWindow(Context context) {
        super(context);
    }

    public OperationPopupWindow(Context context, String title,
                                List<Map<String, Object>> dataList, OnItemClickListener itemsOnClick) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMainView = inflater.inflate(R.layout.popup_dialog, null);
        mTitle = (TextView) mMainView.findViewById(R.id.tv_title);
        mListView = (ListView) mMainView.findViewById(R.id.lv_data);
        mCancle = (TextView) mMainView.findViewById(R.id.tv_cancle);

        // 设置标题
        mTitle.setText(title);
        // 设置列表
        SimpleAdapter adapter = new SimpleAdapter(context, dataList,
                R.layout.popup_text, new String[] { "text" },
                new int[] { R.id.tv_text });
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(itemsOnClick);
        // 取消按钮
        mCancle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 销毁弹出框
                dismiss();
            }
        });

        // 设置PopupWindow的View
        this.setContentView(mMainView);
        // 设置PopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        // 设置PopupWindow弹出窗体的高
        this.setHeight(LayoutParams.MATCH_PARENT);
        // 设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置PopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMainView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMainView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mMainView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }
}
