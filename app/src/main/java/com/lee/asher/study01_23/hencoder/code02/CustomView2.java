package com.lee.asher.study01_23.hencoder.code02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lee.asher.study01_23.hencoder.base.Utils;

/**
 * Created by lihong on 2018/1/29.
 */

public class CustomView2 extends View {
    private static final String TAG = "CustomView";

    private Paint paint = new Paint();
    private int width;

    public CustomView2(Context context) {
        super(context);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        width = Utils.getScreenWidth(getContext());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawColor(Color.RED);

        paint.setStrokeWidth(5);

        paint.setColor(Color.parseColor("#ff0000"));
        canvas.drawRect(20, 100, width / 3 - 20, 200, paint);

        paint.setColor(Color.parseColor("#00ff00"));
        canvas.drawLine(width / 3 + 20, 100, width / 3 * 2 - 20, 200, paint);

        paint.setColor(Color.parseColor("#0000ff"));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        //文字框最高点距离baseline的距离（负数）
        float top = fontMetrics.top;
//        //文字框最低点距离baseline的距离（正数）
//        float bottom = fontMetrics.bottom;
        Log.d(TAG, "onDraw: " + top);
        paint.setTextSize(120);
        canvas.drawText("李宏", width / 3 * 2 + 20, 150 - top, paint);

        LinearGradient gradient = new LinearGradient(0, 400, 200, 400, Color.parseColor("#ff0000"),
                Color.parseColor("#0000ff"), Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        canvas.drawCircle(100, 400, 100, paint);
    }
}
