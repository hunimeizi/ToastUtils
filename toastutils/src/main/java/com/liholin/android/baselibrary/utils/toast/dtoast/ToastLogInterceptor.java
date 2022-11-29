package com.liholin.android.baselibrary.utils.toast.dtoast;

import android.util.Log;

import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToastInterceptor;

import java.lang.reflect.Modifier;

public class ToastLogInterceptor implements IToastInterceptor {

    @Override
    public boolean intercept(ToastParams params) {
        printToast(params.text);
        return false;
    }

    protected void printToast(CharSequence text) {
        if (!isLogEnable()) {
            return;
        }

        // 获取调用的堆栈信息
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        for (StackTraceElement stackTrace : stackTraces) {
            // 获取代码行数
            int lineNumber = stackTrace.getLineNumber();
            if (lineNumber <= 0) {
                continue;
            }

            // 获取类的全路径
            String className = stackTrace.getClassName();
            try {
                Class<?> clazz = Class.forName(className);
                if (!filterClass(clazz)) {
                    printLog("(" + stackTrace.getFileName() + ":" + lineNumber + ") " + text.toString());
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean isLogEnable() {
        return DoToast.isDebugMode();
    }

    protected void printLog(String msg) {
        // 这里解释一下，为什么不用 Log.d，而用 Log.i，因为 Log.d 在魅族 16th 手机上面无法输出日志
        Log.i("ToastUtils", msg);
    }

    protected boolean filterClass(Class<?> clazz) {
        // 排除自身
        if (ToastLogInterceptor.class.equals(clazz)) {
            return true;
        }

        // 排除 ToastUtils 类
        if (DoToast.class.equals(clazz)) {
            return true;
        }

        // 是否为接口类
        if (clazz.isInterface()) {
            return true;
        }

        // 是否为抽象类
        if (Modifier.isAbstract(clazz.getModifiers())) {
            return true;
        }

        return false;
    }
}