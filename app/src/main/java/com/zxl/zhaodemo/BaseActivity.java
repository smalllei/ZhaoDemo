package com.zxl.zhaodemo;

import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * @author： zhaoxiaolei
 * @date: 2017/1/14 0014
 * @time: 15:57
 * @description:  基础类
 */

public class BaseActivity extends FragmentActivity {

    protected  void showToastShort(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    protected void showToastLong(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}
