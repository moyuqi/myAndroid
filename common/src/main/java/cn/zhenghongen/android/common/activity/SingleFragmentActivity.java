package cn.zhenghongen.android.common.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import cn.zhenghongen.android.common.R;

public abstract class SingleFragmentActivity extends BaseActivity {
    /**
     * @return
     */
    protected abstract Fragment createFragment();

    /**
     * @return
     */
    protected int getLayoutResId() {
        return R.layout.activity_single_fragment;
    }

    /**
     * @return
     */
    protected int getFragmentId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(getFragmentId());
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(getFragmentId(), fragment).commit();
        }
    }
}
