package com.liholin.android.toastutils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.View
import com.liholin.android.baselibrary.utils.toast.dtoast.DToast
import com.liholin.android.toastutils.R
import com.liholin.android.toastutils.base.BaseApplication.Companion.instance
import java.util.*

/**
 * Toast工具类，下一个Toast提示前会取消掉上一个Toast
 */
@SuppressLint("InflateParams")
object ToastUtils {
    fun showToast(msg: String?) {
        val mContext = Objects.requireNonNull(instance)?.applicationContext
        if (mContext == null || msg == null) return
        DToast.make(mContext)
            .setView(View.inflate(mContext, R.layout.common_mytoast_layout, null))
            .setText(R.id.text, msg)
            .setGravity(Gravity.TOP, 0, (0.80 * getHeight(mContext)).toInt())
            .showShort()
    }

    fun showToast(msg: Int) {
        val mContext = Objects.requireNonNull(instance)?.applicationContext
        if (mContext == null || msg == 0) return
        DToast.make(mContext)
            .setView(View.inflate(mContext, R.layout.common_mytoast_layout, null))
            .setText(R.id.text, mContext.getString(msg))
            .setGravity(Gravity.TOP, 0, (0.80 * getHeight(mContext)).toInt())
            .showShort()
    }

    //退出APP时调用
    fun cancelAll() {
        DToast.cancel()
    }

    private fun getHeight(context: Context): Int {
        val dm = context.resources.displayMetrics
        return dm.heightPixels
    }
}