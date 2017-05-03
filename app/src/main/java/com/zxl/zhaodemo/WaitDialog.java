package com.zxl.zhaodemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

/**
 * @author: zhaoxiaolei
 * @date: 2017/4/26
 * @time: 15:12
 * @description:
 */

public class WaitDialog extends Dialog {
    public WaitDialog(@NonNull Context context) {
        super(context);
    }

    public WaitDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected WaitDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


}
