package com.liholin.android.toastutils.utils

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.Gravity
import com.liholin.android.baselibrary.utils.toast.dtoast.DoToast
import com.liholin.android.baselibrary.utils.toast.dtoast.ToastParams
import com.liholin.android.baselibrary.utils.toast.dtoast.style.CustomViewToastStyle
import com.liholin.android.toastutils.R


/**
 * Toast工具类，下一个Toast提示前会取消掉上一个Toast
 */
@SuppressLint("InflateParams")
object ToastUtils {
    fun showToast(msg: String?) {
        val params = ToastParams()
        params.text = msg
        params.style = CustomViewToastStyle(R.layout.common_mytoast_layout,
            Gravity.TOP,
            0,
            (0.80 * getHeight()).toInt())
        DoToast.show(params)
    }

    private fun getHeight(): Int {
        val dm = Resources.getSystem().displayMetrics
        return dm.heightPixels
    }
}