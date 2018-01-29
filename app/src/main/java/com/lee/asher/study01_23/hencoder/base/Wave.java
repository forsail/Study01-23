package com.lee.asher.study01_23.hencoder.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by lihong on 2018/1/24.
 */

public class Wave extends View {

    private int color;
    private String text;
    private Paint mPaint, textPaint;
    private Path path;
    private int mWidth, mHeight;

    private float currentPercent;

    public Wave(Context context) {
        super(context);
    }

    public Wave(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        color = Color.rgb(41, 163, 254);
        text = "贴";
        //图形及路径填充画笔（抗锯齿、填充、防抖动）
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(color);
        mPaint.setDither(true);
        //文字画笔（抗锯齿、白色、粗体）
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        //闭合波浪路径
        path = new Path();

        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
    }

    private Path getActionPath(float percent) {
        Path path = new Path();
        int x = -mWidth;
        //当前x点坐标（根据动画进度水平推移，一个动画周期推移的距离为一个周期的波长）
        x += percent * mWidth;
        //波形的起点
        path.moveTo(x, mHeight / 2);
        //控制点的相对宽度
        int quadWidth = mWidth / 4;
        //控制点的相对高度
        int quadHeight = mHeight / 20 * 3;
        //第一个周期波形
        path.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        path.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);
        //第二个周期波形
        path.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        path.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);
        //右侧的直线
        path.lineTo(x + mWidth * 2, mHeight);
        //下边的直线v
        path.lineTo(x, mHeight);
        //自动闭合补出左边的直线
        path.close();
        return path;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //底部的字
        textPaint.setColor(color);
        drawCenterText(canvas, textPaint, text);
        //上层的字
        textPaint.setColor(Color.WHITE);
        //生成闭合波浪路径
        path = getActionPath(currentPercent);
        canvas.clipPath(path);
        //裁剪成圆形
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, mPaint);
        drawCenterText(canvas, textPaint, text);
    }

    private void drawCenterText(Canvas canvas, Paint textPaint, String text) {
        Rect rect = new Rect(0, 0, mWidth, mHeight);
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        //文字框最高点距离baseline的距离（负数）
        float top = fontMetrics.top;
        //文字框最低点距离baseline的距离（正数）
        float bottom = fontMetrics.bottom;

        int centerY = (int) (rect.centerY() - top / 2 - bottom / 2);

        canvas.drawText(text, rect.centerX(), centerY, textPaint);
    }

}
