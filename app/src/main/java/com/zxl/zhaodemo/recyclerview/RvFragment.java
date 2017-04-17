package com.zxl.zhaodemo.recyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zxl.zhaodemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/14
 * @time: 17:31
 * @description:
 */

@SuppressLint("ValidFragment")
public class RvFragment extends Fragment {

    @InjectView(R.id.rv_tv)
    TextView rvTv;
    private String s="";

    @SuppressLint("ValidFragment")
    public RvFragment(String s) {
        this.s = s;
    }

    ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rv, container, false);

        ButterKnife.inject(this, view);
        rvTv.setText(s);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
