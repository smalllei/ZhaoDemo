package com.zxl.zhaodemo.rxjava.rxhelper;

import android.content.Context;
import android.util.Log;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/17
 * @time: 17:28
 * @description:
 */

public abstract class BaseObserver<T> implements Observer<BaseModel<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected BaseObserver() {
        //this.mContext = context.getApplicationContext();
    }

    @Override
    public void onNext(BaseModel<T> value) {
        if (value.isReState()) {
            T t = value.getReResult();
            onHandleSuccess(t);
        } else {
            onHandleError(value.getReMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            onHandleError("连接超时");

        } else if (e instanceof ConnectException) {
            onHandleError("连接异常");

        } else if (e instanceof UnknownHostException) {
            onHandleError("找不到主机");

        } else {
            onHandleError("未知错误");
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    protected abstract void onHandleSuccess(T t);

    protected abstract void onHandleError(String msg) ;
}