package com.liholin.android.toastutils.base

import android.app.Application

/**
 ****************************************
 *Author lybo
 *Email Lhaolin0304@aliyun.com
 *Create by time 2021/3/6 13:36
 *Class 功能（页面）
 ****************************************
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: BaseApplication? = null
            private set
    }

}