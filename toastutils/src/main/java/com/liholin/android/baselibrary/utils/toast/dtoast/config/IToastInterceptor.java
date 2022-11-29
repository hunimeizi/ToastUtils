package com.liholin.android.baselibrary.utils.toast.dtoast.config;

import com.liholin.android.baselibrary.utils.toast.dtoast.ToastParams;

public interface IToastInterceptor {

    /**
     * 根据显示的文本决定是否拦截该 Toast
     */
    boolean intercept(ToastParams params);
}
