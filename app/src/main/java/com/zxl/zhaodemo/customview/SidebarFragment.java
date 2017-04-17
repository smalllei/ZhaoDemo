package com.zxl.zhaodemo.customview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.zxl.zhaodemo.BaseFragment;
import com.zxl.zhaodemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/17
 * @time: 18:15
 * @description: 侧边栏
 */

public class SidebarFragment extends Fragment {
    @InjectView(R.id.sidebar_lv)
    ListView sidebarLv;
    @InjectView(R.id.sidebar_tv)
    TextView sidebarTv;
    @InjectView(R.id.sidebar)
    ZxlSideBar zxlsidebar;


    protected void initView() {
        SidebarEntity sidebar;
        List<SidebarEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("Z");
            sidebar.setName("郑州");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("A");
            sidebar.setName("安阳");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("B");
            sidebar.setName("保定");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("C");
            sidebar.setName("CCCC");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("D");
            sidebar.setName("郑州");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("M");
            sidebar.setName("郑州");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("N");
            sidebar.setName("郑州");
            list.add(sidebar);
        }
        for (int i = 0; i < 10; i++) {
            sidebar = new SidebarEntity();
            sidebar.setInitialLetter("X");
            sidebar.setName("郑州");
            list.add(sidebar);
        }
        //需提前排序
        SidebarAdapter adapter = new SidebarAdapter(getActivity(), R.layout.item_quhao, list);
        sidebarLv.setAdapter(adapter);
        zxlsidebar.setListView(sidebarLv);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = inflater.inflate(R.layout.item_sidebar, container, false);
        ButterKnife.inject(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
