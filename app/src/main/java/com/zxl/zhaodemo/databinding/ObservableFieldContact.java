package com.zxl.zhaodemo.databinding;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/7
 * @time: 16:33
 * @description:
 */

public class ObservableFieldContact {
    public ObservableField<String> mName=new ObservableField<>();
    public ObservableField<String> mPhone=new ObservableField<>();
    public ObservableArrayMap<String ,String> mUser=new ObservableArrayMap<>();
    public ObservableFieldContact(String name,String phone){
        mName.set(name);
        mPhone.set(phone);
        mUser.put("firstName","Jack");
        mUser.put("lastName","Tom");
        mUser.put("age","24");

    }

}
