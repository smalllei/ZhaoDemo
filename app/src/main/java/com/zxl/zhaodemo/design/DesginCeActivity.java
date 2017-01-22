package com.zxl.zhaodemo.design;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.eventbus.VpBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/17 0017
 * @time: 11:22
 * @description: desgin 侧滑实现,以及一些常用组件
 */

public class DesginCeActivity extends BaseActivity {
    @InjectView(R.id.desgin_ce_nav)
    NavigationView desginCeNav;
    @InjectView(R.id.desgin_toolbar)
    Toolbar desginToolbar;
    @InjectView(R.id.desgin_tablayout)
    TabLayout desginTablayout;
    @InjectView(R.id.desgin_appbar)
    AppBarLayout desginAppbar;
    @InjectView(R.id.desgin_vp)
    ViewPager desginVp;
    @InjectView(R.id.desgin_FloatingActionButton)
    FloatingActionButton desginFloatingActionButton;
    @InjectView(R.id.desgin_drawer)
    DrawerLayout desginDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desigin_cehua);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        //悬浮按钮
        desginFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"come on baby",Snackbar.LENGTH_SHORT).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }).show();
            }
        });

        setSupportActionBar(desginToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.qq);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(desginCeNav);
        //让每个item显示自己的颜色
        desginCeNav.setItemIconTintList(null);
        View view = desginCeNav.getHeaderView(0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastShort("头部点击了");
            }
        });
        desginCeNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                showToastShort(item.getTitle().toString());
                return true;
            }
        });

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        fragments.add(new StickyNavLayoutFragment());
        String[] strings = {"1", "2", "3", "4"};
        VpBaseAdapter vpBaseAdapter = new VpBaseAdapter(getSupportFragmentManager(), strings, fragments);
        desginVp.setAdapter(vpBaseAdapter);
        desginVp.setOffscreenPageLimit(3);
        desginTablayout.setupWithViewPager(desginVp);
        desginTablayout.setTabsFromPagerAdapter(vpBaseAdapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        desginDrawer.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                desginDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
