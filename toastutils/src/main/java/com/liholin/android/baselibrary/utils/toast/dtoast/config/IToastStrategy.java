package com.liholin.android.baselibrary.utils.toast.dtoast.config;

import android.app.Application;

import com.liholin.android.baselibrary.utils.toast.dtoast.ToastParams;

public interface IToastStrategy {

    /**
     * 注册策略
     */
    void registerStrategy(Application application);

    /**
     * 创建 Toast
     */
    IToast createToast(IToastStyle<?> style);

    /**
     * 显示 Toast
     */
    void showToast(ToastParams params);

    /**
     * 取消 Toast
     */
    void cancelToast();
}
