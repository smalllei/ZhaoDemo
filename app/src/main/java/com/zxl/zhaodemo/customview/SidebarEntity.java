package com.zxl.zhaodemo.customview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ${zxl} on 2017/4/12.
 * D: 区号实体类
 * C:
 */

public class SidebarEntity implements Parcelable{


    protected String initialLetter;
    protected String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getInitialLetter() {
        if (initialLetter == null) {
            return "#";
        }
        return initialLetter;
    }

    public void setInitialLetter(String initialLetter) {
        this.initialLetter = initialLetter;
    }

    public SidebarEntity(){}
    private SidebarEntity(Parcel in) {
        name = in.readString();
    }

    public static final Creator<SidebarEntity> CREATOR = new Creator<SidebarEntity>() {
        @Override
        public SidebarEntity createFromParcel(Parcel in) {
            return new SidebarEntity(in);
        }

        @Override
        public SidebarEntity[] newArray(int size) {
            return new SidebarEntity[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
