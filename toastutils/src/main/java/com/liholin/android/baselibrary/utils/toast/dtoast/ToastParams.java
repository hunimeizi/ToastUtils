package com.liholin.android.baselibrary.utils.toast.dtoast;

import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToastInterceptor;
import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToastStrategy;
import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToastStyle;

public class ToastParams {

    /** 显示的文本 */
    public CharSequence text;

    /**
     * Toast 显示时长，有两种值可选
     *
     * 短吐司：{@link android.widget.Toast#LENGTH_SHORT}
     * 长吐司：{@link android.widget.Toast#LENGTH_LONG}
     */
    public int duration = -1;

    /** 延迟显示时间 */
    public long delayMillis = 0;

    /** Toast 样式 */
    public IToastStyle<?> style;

    /** Toast 策略 */
    public IToastStrategy strategy;

    /** Toast 拦截器 */
    public IToastInterceptor interceptor;
}
