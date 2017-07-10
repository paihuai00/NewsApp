package com.fifedu.rxfiflibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fifedu.rxfiflibrary.R;

/**
 * 弹窗类
 * 
 * @author RXXU Toast自定义
 */
public class ToastUtil {

    /********************************* 提示弹窗 ***************************************/
    // /** 提示Toast */
    // private static Toast notice_toast = null;
    // /** Context */
    // private static Context notice_context = null;
    // /** 标题 */
    // private static TextView notice_title = null;
    // /** 图标 */
    // private static ImageView notice_icon = null;

    public static Toast createCustomToast(Context context, String title,
                                          int iconRes) {
        /** 初始化 */
        Toast notice_toast = new BaseToast(context);
        notice_toast.setGravity(Gravity.CENTER_HORIZONTAL
                | Gravity.CENTER_VERTICAL, 0, 0);
        notice_toast.setDuration(Toast.LENGTH_SHORT);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_notice,
                null);
        TextView notice_title = (TextView) view.findViewById(R.id.title);
        ImageView notice_icon = (ImageView) view.findViewById(R.id.icon);
        if (!TextUtils.isEmpty(title)) {
            notice_title.setText(title);
        }
        if (iconRes != 0) {
            notice_icon.setBackgroundResource(iconRes);
        }
        notice_toast.setView(view);
        return notice_toast;
    }

    /**
     * 列表弹窗
     */
    public static void showNoticeToast(Context context, String title) {
        // 2.2版本以上保存context
        // if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
        // if (notice_toast == null || notice_context == null
        // || notice_context != context) {
        // createNoticeToast(context);
        // }
        // } else {
        // createNoticeToast(context);
        // }
        // if (title != null) {
        // notice_title.setText(title);
        // }
        // notice_toast.show();
        createCustomToast(context, title, R.drawable.toast_icon_warning).show();
    }

    /********************************* 错误弹窗 ***************************************/
    // /** 提示Toast */
    // private static Toast error_toast = null;
    // /** Context */
    // private static Context error_context = null;
    // /** 标题 */
    // private static TextView error_title = null;
    // /** 图标 */
    // private static ImageView error_icon = null;
    //
    // public static Toast createErrorToast(Context context) {
    // /** 初始化 */
    // Toast error_toast = new Toast(context);
    // error_toast.setGravity(Gravity.CENTER_HORIZONTAL
    // | Gravity.CENTER_VERTICAL, 0, 0);
    // error_toast.setDuration(Toast.LENGTH_SHORT);
    // View view = LayoutInflater.from(context).inflate(R.layout.toast_error,
    // null);
    // TextView error_title = (TextView) view.findViewById(R.id.title);
    // ImageView error_icon = (ImageView) view.findViewById(R.id.icon);
    // error_toast.setView(view);
    // return error_toast;
    // }

    /**
     * 列表弹窗
     */
    public static void showErrorToast(Context context, String title) {
        // 2.2版本以上保存context
        // if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
        // if (error_toast == null || error_context == null
        // || error_context != context) {
        // createErrorToast(context);
        // }
        // } else {
        // createErrorToast(context);
        // }
        // if (title != null) {
        // error_title.setText(title);
        // }
        // error_toast.show();
        createCustomToast(context, title, R.drawable.toast_icon_error).show();
    }

    /********************************* 正确弹窗 ***************************************/
    // /** 提示Toast */
    // private static Toast hook_toast = null;
    // /** Context */
    // private static Context hook_context = null;
    // /** 标题 */
    // private static TextView hook_title = null;
    // /** 图标 */
    // private static ImageView hook_icon = null;

    // public static void createHookToast(Context context) {
    /** 初始化 */
    // hook_toast = new Toast(context);
    // hook_toast.setGravity(Gravity.CENTER_HORIZONTAL
    // | Gravity.CENTER_VERTICAL, 0, 0);
    // hook_toast.setDuration(Toast.LENGTH_SHORT);
    // View view = LayoutInflater.from(context).inflate(R.layout.toast_hook,
    // null);
    // hook_title = (TextView) view.findViewById(R.id.title);
    // hook_icon = (ImageView) view.findViewById(R.id.icon);
    // hook_toast.setView(view);
    // hook_context = context;
    // }

    /**
     * 列表弹窗
     */
    public static void showHookToast(Context context, String title) {
        // 2.2版本以上保存context
        // if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
        // if (hook_toast == null || hook_context == null
        // || hook_context != context) {
        // createHookToast(context);
        // }
        // } else {
        // createHookToast(context);
        // }
        // if (title != null) {
        // hook_title.setText(title);
        // }
        // hook_toast.show();
        createCustomToast(context, title, R.drawable.toast_icon_hook).show();
    }

//    /**
//     * 列表弹窗
//     */
//    public static void showNoticeToast(Context context, int resid) {
//        createCustomToast(context, context.getResources().getString(resid),
//                R.drawable.toast_icon_warning).show();
//    }
//
//    /********************************* 错误弹窗 ***************************************/
//    public static void showErrorToast(Context context, int resid) {
//        createCustomToast(context, context.getResources().getString(resid),
//                R.drawable.toast_icon_error).show();
//    }
//
//    /********************************* 正确弹窗 ***************************************/
//    public static void showHookToast(Context context, int resid) {
//        createCustomToast(context, context.getResources().getString(resid),
//                R.drawable.toast_icon_hook).show();
//    }

}
