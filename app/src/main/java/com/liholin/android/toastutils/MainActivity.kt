package com.liholin.android.toastutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.liholin.android.toastutils.utils.ToastUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnShowToast).setOnClickListener {
            ToastUtils.showToast("toast")
        }
    }
}