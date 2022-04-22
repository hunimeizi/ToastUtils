package com.liholin.android.baselibrary.utils.toast.dtoast;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.IntDef;
import androidx.core.app.NotificationManagerCompat;

import com.liholin.android.baselibrary.utils.toast.dtoast.inner.ActivityToast;
import com.liholin.android.baselibrary.utils.toast.dtoast.inner.DovaToast;
import com.liholin.android.baselibrary.utils.toast.dtoast.inner.IToast;
import com.liholin.android.baselibrary.utils.toast.dtoast.inner.SystemToast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DToast {

    public static void enableLog(boolean enable) {
        DUtil.enableLog = enable;
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DURATION_SHORT, DURATION_LONG})
    public @interface Duration {
    }

    public static final int DURATION_SHORT = 2000;
    public static final int DURATION_LONG = 3500;

    public static IToast make(Context mContext) {
        if (mContext == null) return null;
        //如果有通知权限，直接使用系统Toast
        //白名单中的机型没有通知权限时系统Toast也能正常展示
        if (NotificationManagerCompat.from(mContext).areNotificationsEnabled() || SystemToast.isValid4HookINotificationManager() || DUtil.isWhiteList()) {
            return new SystemToast(mContext);
        } else {//否则使用自定义Toast
            if (mContext instanceof Activity && DovaToast.isBadChoice()) {
                //检测到DovaToast连续多次抛出token null is not valid异常时，直接启用ActivityToast
                return new ActivityToast(mContext);
            }
            return new DovaToast(mContext);
        }
    }

    /**
     * 终止并清除所有弹窗
     */
    public static void cancel() {
        DovaToast.cancelAll();
        SystemToast.cancelAll();
    }

    /**
     * 清除与{@param mActivity}关联的ActivityToast，避免窗口泄漏
     */
    public static void cancelActivityToast(Activity mActivity) {
        DovaToast.cancelActivityToast(mActivity);
    }
}
