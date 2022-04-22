package com.liholin.android.baselibrary.utils.toast.dtoast.inner;


import android.view.View;

import androidx.annotation.IdRes;

import com.liholin.android.baselibrary.utils.toast.dtoast.DToast;

public interface IToast {
    void show();

    void showLong();

    void showShort();

    void cancel();

    IToast setView(View mView);

    View getView();

    IToast setDuration(@DToast.Duration int duration);

    IToast setGravity(int gravity);

    IToast setGravity(int gravity, int xOffset, int yOffset);

    IToast setAnimation(int animation);

    IToast setPriority(int mPriority);

    IToast setText(@IdRes int id, String text);
}
