package com.liholin.android.baselibrary.utils.toast.dtoast;

import android.app.Application;

public class ApplicationToast extends CustomToast {

    /** Toast 实现类 */
    private final ToastImpl mToastImpl;

    public ApplicationToast(Application application) {
        mToastImpl = new ToastImpl(application, this);
    }

    @Override
    public void show() {
        // 替换成 WindowManager 来显示
        mToastImpl.show();
    }

    @Override
    public void cancel() {
        // 取消 WindowManager 的显示
        mToastImpl.cancel();
    }
}
