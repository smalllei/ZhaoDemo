package com.zxl.zhaodemo.design;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;

import com.zxl.zhaodemo.BaseActivity;
import com.zxl.zhaodemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/17 0017
 * @time: 11:22
 * @description: desgin 侧滑实现
 */

public class DesginCeActivity extends BaseActivity {
    @InjectView(R.id.desgin_ce_nav)
    NavigationView desginCeNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desigin_cehua);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        //让每个item显示自己的颜色
        desginCeNav.setItemIconTintList(null);
        View view= desginCeNav.getHeaderView(0);
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
    }
}
