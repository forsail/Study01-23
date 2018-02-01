package com.lee.asher.study01_23.hencoder.code3;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lihong on 2018/2/1.
 */

public class CustomView3 extends View {
    private static final String TAG = "CustomView3";

    public CustomView3(Context context) {
        super(context);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: ");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");
    }

    /**
     * requestLayout调用时会执行measure和draw过程
     */
    public void execRequestLayout() {
        requestLayout();
    }

    /**
     * invalidate调用时会执行draw过程
     */
    public void execInvalidate() {
        invalidate();
    }
}
