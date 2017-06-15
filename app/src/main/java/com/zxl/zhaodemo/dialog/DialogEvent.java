package com.zxl.zhaodemo.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;
import android.widget.Toast;

import com.zxl.zhaodemo.MyApplication;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/15
 * @time: 14:45
 * @description:
 */

public class DialogEvent {
    private Activity activity;

    public DialogEvent(Activity activity) {
        this.activity = activity;
    }

    public void showTipDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("系统通知");
        builder.setMessage("databinding好用么");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(activity, "-<>-", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }


    public void showSystemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("系统通知");
        builder.setMessage("谁说我要依赖activity的");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MyApplication.getAppContext(), "-》《-", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog = builder.create();
        //权限开启也不行。。。。。。。。。。。。。。。。。。。
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }
}
