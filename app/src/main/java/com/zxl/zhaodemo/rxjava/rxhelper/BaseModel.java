package com.zxl.zhaodemo.rxjava.rxhelper;

import java.io.Serializable;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/17
 * @time: 11:42
 * @description:
 */

public class BaseModel<T> implements Serializable{
    private Boolean ReState = false;
    private T ReResult;
    private String ReMessage;
    private String ReToken;


    public T getReResult() {
        return ReResult;
    }

    public void setReResult(T reResult) {
        ReResult = reResult;
    }

    public Boolean isReState() {
        return ReState;
    }

    public void setReState(Boolean reState) {
        ReState = reState;
    }

    public String getReMessage() {
        return ReMessage;
    }

    public void setReMessage(String reMessage) {
        ReMessage = reMessage;
    }

    public String getReToken() {
        return ReToken;
    }

    public void setReToken(String reToken) {
        ReToken = reToken;
    }

}
