package com.zxl.zhaodemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/17
 * @time: 18:15
 * @description:
 */

public abstract class BaseFragment extends Fragment{
    protected View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(getLayout(),container,false);
      //  ButterKnife.inject(getActivity(),rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
      //  ButterKnife.reset(getActivity());
    }

    protected abstract int  getLayout();
    protected abstract void initView();
}
