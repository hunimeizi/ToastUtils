package com.liholin.android.baselibrary.utils.toast.dtoast.style;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.liholin.android.baselibrary.utils.toast.dtoast.config.IToastStyle;

public class CustomViewToastStyle implements IToastStyle<View> {

    private final int mLayoutId;
    private final int mGravity;
    private final int mXOffset;
    private final int mYOffset;
    private final float mHorizontalMargin;
    private final float mVerticalMargin;

    public CustomViewToastStyle(int id) {
        this(id, Gravity.CENTER);
    }

    public CustomViewToastStyle(int id, int gravity) {
        this(id, gravity, 0, 0);
    }

    public CustomViewToastStyle(int id, int gravity, int xOffset, int yOffset) {
        this(id, gravity, xOffset, yOffset, 0f, 0f);
    }

    public CustomViewToastStyle(int id, int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin) {
        mLayoutId = id;
        mGravity = gravity;
        mXOffset = xOffset;
        mYOffset = yOffset;
        mHorizontalMargin = horizontalMargin;
        mVerticalMargin = verticalMargin;
    }

    @Override
    public View createView(Context context) {
        return LayoutInflater.from(context).inflate(mLayoutId, null);
    }

    @Override
    public int getGravity() {
        return mGravity;
    }

    @Override
    public int getXOffset() {
        return mXOffset;
    }

    @Override
    public int getYOffset() {
        return mYOffset;
    }

    @Override
    public float getHorizontalMargin() {
        return mHorizontalMargin;
    }

    @Override
    public float getVerticalMargin() {
        return mVerticalMargin;
    }
}