package com.zxl.zhaodemo.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.eventbus.VpBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/16 0016
 * @time: 13:46
 * @description: hongyang 可悬停
 */

public class StickyNavLayoutActivity extends BaseActivity {

    @InjectView(R.id.id_stickynavlayout_topview)
    RelativeLayout idStickynavlayoutTopview;
    @InjectView(R.id.id_stickynavlayout_indicator)
    TabLayout idStickynavlayoutIndicator;
    @InjectView(R.id.id_stickynavlayout_viewpager)
    ViewPager idStickynavlayoutViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickylayout);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        String [] strings={"1","2","3","4"};
        VpBaseAdapter vpBaseAdapter=new VpBaseAdapter(getSupportFragmentManager(),strings,fragments);
        idStickynavlayoutViewpager.setAdapter(vpBaseAdapter);
        idStickynavlayoutViewpager.setOffscreenPageLimit(3);
        idStickynavlayoutIndicator.setupWithViewPager(idStickynavlayoutViewpager);
        idStickynavlayoutIndicator.setTabsFromPagerAdapter(vpBaseAdapter);
    }
}
