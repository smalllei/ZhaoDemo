package com.zxl.zhaodemo;

import android.app.Application;



/**
 * @author： zhaoxiaolei
 * @date: 2017/1/14 0014
 * @time: 15:56
 * @description:
 */

public class MyApplication extends Application {
    public static  MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
              myApplication=this;
    }
    public static MyApplication getAppContext(){
        if (myApplication==null){
            myApplication=new MyApplication();
        }
        return myApplication;
    }
}
