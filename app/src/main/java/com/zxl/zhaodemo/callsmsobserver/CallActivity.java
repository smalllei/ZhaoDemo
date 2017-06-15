package com.zxl.zhaodemo.callsmsobserver;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.zxl.zhaodemo.BaseActivity1;
import com.zxl.zhaodemo.R;
import com.zxl.zhaodemo.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * @author: zhaoxiaolei
 * @date: 2017/6/12
 * @time: 16:42
 * @description:
 */

public class CallActivity extends BaseActivity1 {
    @InjectView(R.id.call_tv_call)
    TextView callTvCall;
    @InjectView(R.id.call_tv_sms)
    TextView callTvSms;
    @InjectView(R.id.call_tv_title)
    TextView callTvTitle;
    private PhoneContentObserver observer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_call;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            showToast(s);
        }
    };

    @Override
    protected void initView() {
        observer = new PhoneContentObserver(this, handler);
        getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI, true, observer);
    }

    @Override
    protected void initEvent() {
        callTvCall.setOnClickListener(this);
        callTvSms.setOnClickListener(this);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.call_tv_call:
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + "15538869641"));
                startActivity(intent);
                break;
            case R.id.call_tv_sms:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(observer);
    }


    class PhoneContentObserver extends ContentObserver {
        private Context context;
        private Handler handler;

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public PhoneContentObserver(Context context, Handler handler) {
            super(handler);
            this.context = context;
            this.handler = handler;
        }


        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            /****************获取到通话记录表的最新一条消息******************/
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, // 使用系统URI，取得通话记录

                    new String[]{CallLog.Calls.NUMBER, // 电话号码

                            CallLog.Calls.CACHED_NAME, // 联系人

                            CallLog.Calls.TYPE, // 通话类型

                            CallLog.Calls.DATE, // 通话时间

                            CallLog.Calls.DURATION // 通话时长

                    }, null, null, CallLog.Calls.DEFAULT_SORT_ORDER);
            cursor.moveToFirst();
            String name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
            long date = cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE));

            /** Call log type for incoming calls. */
            //public static final int INCOMING_TYPE = 1;
            /** Call log type for outgoing calls. */
           // public static final int OUTGOING_TYPE = 2;
            /** Call log type for missed calls. */
           // public static final int MISSED_TYPE = 3;
            /** Call log type for voicemails. */
           // public static final int VOICEMAIL_TYPE = 4;
            /** Call log type for calls rejected by direct user action. */
           // public static final int REJECTED_TYPE = 5;
            /** Call log type for calls blocked automatically. */
            //public static final int BLOCKED_TYPE = 6;
            int type = cursor.getInt(cursor.getColumnIndex(CallLog.Calls.TYPE));
            int duration=cursor.getInt(cursor.getColumnIndex(CallLog.Calls.DURATION));
            Message msg = new Message();
            msg.obj = name + number + date + type;
            handler.sendMessage(msg);
            LogUtils.e(name + "\n" + number + "\n" + date + "\n" + type+"\n"+duration);
            LogUtils.e(name + "\n" + number + "\n" + date + "\n" + type+"\n"+duration);
            LogUtils.e(name + "\n" + number + "\n" + date + "\n" + type+"\n"+duration);
            LogUtils.e(name + "\n" + number + "\n" + date + "\n" + type+"\n"+duration);
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
