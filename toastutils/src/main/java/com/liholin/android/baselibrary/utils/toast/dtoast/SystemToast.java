package com.liholin.android.baselibrary.utils.toast.dtoast;

import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToast;

public class SystemToast extends Toast implements IToast {

    /** 吐司消息 View */
    private TextView mMessageView;

    public SystemToast(Application application) {
        super(application);
    }

    @Override
    public void setView(View view) {
        super.setView(view);
        if (view == null) {
            mMessageView = null;
            return;
        }
        mMessageView = findMessageView(view);
    }

    @Override
    public void setText(CharSequence text) {
        super.setText(text);
        if (mMessageView == null) {
            return;
        }
        mMessageView.setText(text);
    }
}