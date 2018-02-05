package com.lee.asher.study01_23.hencoder.code3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lihong on 2018/2/1.
 */

public class CustomView3 extends View {
    private static final String TAG = "CustomView3";

    private Path path;
    private Paint paint;

    public CustomView3(Context context) {
        super(context);
    }

    public CustomView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CW);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#333333"));
        paint.setTextSize(20);
        paint.setStyle(Paint.Style.STROKE);
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
        canvas.drawPath(path, paint);
        canvas.drawTextOnPath("小姑凉", path, 0, 0, paint);

        String str = "李宏是个小达人";
        canvas.drawText(str, 500, 200, paint);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, 7, rect);
        Log.d(TAG, "onDraw:getTextBounds " + rect.width());
        Log.d(TAG, "onDraw:measureText " + paint.measureText(str));
        canvas.drawLine(500, 200, 500 + paint.measureText(str), 200, paint);
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
