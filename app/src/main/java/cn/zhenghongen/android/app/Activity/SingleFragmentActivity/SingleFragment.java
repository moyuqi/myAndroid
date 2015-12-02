package cn.zhenghongen.android.app.Activity.SingleFragmentActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.zhenghongen.android.app.R;

public class SingleFragment extends Fragment {
    public SingleFragment() {
        // Required empty public constructor
    }

    public static SingleFragment newInstance(String param1, String param2) {
        SingleFragment fragment = new SingleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.single_fragment_fragment_single, container, false);
    }

}
