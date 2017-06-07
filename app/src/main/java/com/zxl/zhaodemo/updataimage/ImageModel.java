package com.zxl.zhaodemo.updataimage;

import java.io.Serializable;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/6
 * @time: 11:07
 * @description:
 */

public class ImageModel implements Serializable{
    int code;
    String message;
    Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
