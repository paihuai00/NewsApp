package com.fifedu.rxfiflibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 自定义Toast，解决Toast长时间不消失的问题
 * 
 * @author
 * @version Create Time：Jun 12, 2015 2:06:52 PM
 */
public class BaseToast extends Toast {

    private static Toast mToast;

    public BaseToast(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = this;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        super.show();
    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
        super.cancel();
        mToast = null;
    }

}
