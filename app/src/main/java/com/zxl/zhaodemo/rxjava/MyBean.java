package com.zxl.zhaodemo.rxjava;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/5.
 */

public class MyBean<T> implements Serializable {

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
