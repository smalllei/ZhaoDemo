package com.zxl.zhaodemo.dialog;

import android.app.Dialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;
import android.widget.Toast;

import com.zxl.zhaodemo.MyApplication;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/15
 * @time: 15:25
 * @description:
 */

public class DialogService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }
}
