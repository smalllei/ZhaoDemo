package com.zxl.zhaodemo.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zxl.zhaodemo.BaseFragment;
import com.zxl.zhaodemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author: zhaoxiaolei
 * @date: 2017/7/3
 * @time: 15:45
 * @description:
 */

public class ViewPagerFragment extends Fragment {

    ImageView flViewpagerIv;
    int image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_viewpager,container,false);

        return view;
    }
}
