package com.zxl.zhaodemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zxl.zhaodemo.calendar.CalendarView;
import com.zxl.zhaodemo.utils.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/26
 * @time: 15:05
 * @description: 基础类
 */

public abstract class BaseActivity1 extends AppCompatActivity implements View.OnClickListener {
    private boolean isTest = true;
    private boolean isDebug = false;
    protected final String TAG = this.getClass().getSimpleName();


    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showTestToast(String msg) {
        if (isTest) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setStatusBar();
        ButterKnife.inject(this);
        initView();
        initEvent();

    }


    protected void setStatusBar() {
        StatusBarUtil.setColor(this, Color.GREEN, 0);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initEvent();

    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void LogD(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }
    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void LogE(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    /**
     * View点击
     **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


}
