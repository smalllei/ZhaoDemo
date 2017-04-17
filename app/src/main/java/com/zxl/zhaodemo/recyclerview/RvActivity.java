package com.zxl.zhaodemo.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.customview.SidebarFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author:zhaoxiaolei
 * @date:2017/4/14
 * @time:17:05
 * @description: recyclerView
 */

public class RvActivity extends BaseActivity {
    @InjectView(R.id.rv_tab)
    TabLayout rvTab;
    @InjectView(R.id.rv_vp)
    ViewPager rvVp;
    private List<String> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {
        titles = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i==0){
                titles.add("侧边栏");
            }
            else if (i % 3 == 0) {
                titles.add("标题" + i);
            } else if (i % 3 == 1) {
                titles.add("一般标题" + i);
            } else {
                titles.add("很长很长的标题" + i);
            }
        }
        fragments = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i==0){
                fragments.add(new SidebarFragment());
            }
            else if (i % 3 == 0) {
                fragments.add(new RvFragment("标题" + i));
            } else if (i % 3 == 1) {
                fragments.add(new RvFragment("一般标题" + i));
            } else {
                fragments.add(new RvFragment("很长很长的标题" + i));
            }
        }
        for (int i=0;i<titles.size();i++){
            rvTab.addTab(rvTab.newTab().setText(titles.get(i)));
        }
        VpBaseAdapter adapter=new VpBaseAdapter(getSupportFragmentManager(),titles,fragments);
        rvVp.setAdapter(adapter);
        rvTab.setupWithViewPager(rvVp);
        rvVp.setOffscreenPageLimit(5);
        rvTab.setTabsFromPagerAdapter(adapter);


    }
}
