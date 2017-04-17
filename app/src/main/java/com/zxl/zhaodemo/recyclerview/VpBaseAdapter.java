package com.zxl.zhaodemo.recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/16 0016
 * @time: 9:19
 * @description: viewpager 通用适配器
 */

public class VpBaseAdapter extends FragmentStatePagerAdapter{
    private List<String> titles;
    private List<Fragment> fragmnets;

    public VpBaseAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragmnets=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmnets.get(position);
    }

    @Override
    public int getCount() {
        return fragmnets.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
