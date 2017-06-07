package com.zxl.zhaodemo.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.zxl.zhaodemo.utils.ToastUtils;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/7
 * @time: 11:32
 * @description:
 */

public class TestEvent {
    private Context mContext;
    public TestEvent(Context mContext){
        this.mContext=mContext;
    }
    public TestEvent(){

    }
    public void onEvent(TestData data){
        //data=new TestData("123","321");
        Toast.makeText(mContext, "onEvent:"+data.firstName+"\n"+data.lastName, Toast.LENGTH_LONG).show();
    }

    public void  onClickFriend(View view){
        ToastUtils.show("onClickFriend");
    }
    public void onSaveClick(View view,TestData data){
        Toast.makeText(mContext, "onSaveClick:"+data.firstName+"\n"+data.lastName, Toast.LENGTH_LONG).show();

    }


    public void onCompletedChanged(boolean completed,TestData data){
        if (completed){
            ToastUtils.show("onCompletedChanged:"+data.lastName);
        }
        else {
            ToastUtils.show("onCompletedChanged:"+data.firstName);
        }

    }


    public void loadString(Context context){
        Toast.makeText(context, "loadString:", Toast.LENGTH_LONG).show();

    }
}
