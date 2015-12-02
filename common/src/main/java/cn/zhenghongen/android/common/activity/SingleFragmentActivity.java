package cn.zhenghongen.android.common.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import cn.zhenghongen.android.common.R;

public abstract class SingleFragmentActivity extends BaseActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}
