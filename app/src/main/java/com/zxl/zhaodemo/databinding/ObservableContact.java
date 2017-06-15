package com.zxl.zhaodemo.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

import com.android.databinding.library.baseAdapters.BR;


/**
 * @author: zhaoxiaolei
 * @date: 2017/6/7
 * @time: 16:02
 * @description:
 */

public class ObservableContact extends BaseObservable {


    private String mName;


    private String mPhone;

    public ObservableContact(String name, String phone) {
        mName = name;
        mPhone = phone;
    }
    @Bindable
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
        notifyPropertyChanged(BR.mName);
    }
    @Bindable
    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
        notifyPropertyChanged(BR.mPhone);
    }

}
