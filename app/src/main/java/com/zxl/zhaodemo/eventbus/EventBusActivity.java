package com.zxl.zhaodemo.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/16 0016
 * @time: 8:43
 * @description: eventbus
 */

public class EventBusActivity extends BaseActivity {


    @InjectView(R.id.eventbus_tablayout)
    TabLayout eventbusTablayout;
    @InjectView(R.id.eventbus_vp)
    ViewPager eventbusVp;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        initView();
    }

    /**
     * 数据初始化
     */
    private void initView() {
        EventBusFragment eventBusFragment1 = new EventBusFragment();
        EventBusFragment eventBusFragment2 = new EventBusFragment();
        EventBusFragment eventBusFragment3 = new EventBusFragment();
        EventBusFragment eventBusFragment4 = new EventBusFragment();
        fragments = new ArrayList<>();
        String[] titles =  {"test11", "test22", "test33", "test44"};
        fragments.add(eventBusFragment1);
        fragments.add(eventBusFragment2);
        fragments.add(eventBusFragment3);
        fragments.add(eventBusFragment4);
        Bundle bundle=new Bundle();
        bundle.putInt("tag",1);
        eventBusFragment1.setArguments(bundle);
        Bundle bundle1=new Bundle();
        bundle1.putInt("tag",2);
        eventBusFragment2.setArguments(bundle1);
        Bundle bundle2=new Bundle();
        bundle2.putInt("tag",3);
        eventBusFragment3.setArguments(bundle2);
        Bundle bundle3=new Bundle();
        bundle3.putInt("tag",4);
        eventBusFragment4.setArguments(bundle3);
        eventbusTablayout.addTab(eventbusTablayout.newTab().setText(titles[0]));
        eventbusTablayout.addTab(eventbusTablayout.newTab().setText(titles[1]));
        eventbusTablayout.addTab(eventbusTablayout.newTab().setText(titles[2]));
        eventbusTablayout.addTab(eventbusTablayout.newTab().setText(titles[3]));
        VpBaseAdapter vpBaseAdapter=new VpBaseAdapter(getSupportFragmentManager(), titles, fragments);
        eventbusVp.setAdapter(vpBaseAdapter);
        //缓存相隔两个的界面
        eventbusVp.setOffscreenPageLimit(3);
        eventbusTablayout.setupWithViewPager(eventbusVp);
        eventbusTablayout.setTabsFromPagerAdapter(vpBaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public  void onEvent(EventBusMessage message){
        eventbusVp.setCurrentItem(2);
        showToastShort(message.test);
    }
}
