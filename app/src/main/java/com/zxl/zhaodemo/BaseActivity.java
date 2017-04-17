package com.zxl.zhaodemo;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxl.zhaodemo.utils.StatusBarUtil;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/14 0014
 * @time: 15:57
 * @description:  基础类
 */

public class BaseActivity extends AppCompatActivity {

    protected  void showToastShort(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    protected void showToastLong(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setStatusBar();
        super.setContentView(layoutResID);
    }
    public void setStatusBar(){
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent),0);
    }
}
