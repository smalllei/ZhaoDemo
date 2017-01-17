package com.zxl.zhaodemo.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zxl.zhaodemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/16 0016
 * @time: 13:49
 * @description:
 */

public class StickyNavLayoutFragment extends Fragment {
    @InjectView(R.id.id_stickynavlayout_innerscrollview)
    RecyclerView idStickynavlayoutInnerscrollview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stickylayout, container, false);
        ButterKnife.inject(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<String> strings=new ArrayList<>();
        for (int i=0;i<50;i++) {
            strings.add("报数"+i);
        }
        idStickynavlayoutInnerscrollview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        idStickynavlayoutInnerscrollview.setAdapter(new CommonAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,strings) {
            @Override
            protected void convert(ViewHolder holder, String o, int position) {
                holder.setText(android.R.id.text1,o);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
