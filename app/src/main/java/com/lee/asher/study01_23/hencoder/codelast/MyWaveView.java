package com.lee.asher.study01_23.hencoder.codelast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.lee.asher.study01_23.hencoder.base.Utils;

/**
 * Created by lihong on 2018/1/31.
 */

public class MyWaveView extends View {

    private int width;
    private Paint circlePaint;
    private Paint textPaint;
    private Path path;
    private float percent;

    public MyWaveView(Context context) {
        super(context);
        init();
    }

    public MyWaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.parseColor("#498ff7"));

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStrokeWidth(20);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(Utils.sp2px(getContext(), 25));

        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                percent = animation.getAnimatedFraction();
                invalidate();
            }
        });

        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if (mode != MeasureSpec.EXACTLY) {
            width = Utils.dip2px(80);
        }

        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        textPaint.setColor(Color.parseColor("#498ff7"));
        drawCenterText(canvas, "宏", width / 2, width / 2, textPaint);
        path = getPath(percent);
        canvas.clipPath(path);
        canvas.drawCircle(width / 2, width / 2, width / 2, circlePaint);
        textPaint.setColor(Color.parseColor("#ffffff"));
        drawCenterText(canvas, "宏", width / 2, width / 2, textPaint);
    }

    private Path getPath(float percent) {
        Path path = new Path();
        int x = -width;
        //当前x点坐标（根据动画进度水平推移，一个动画周期推移的距离为一个周期的波长）
        x += percent * width;
        //波形的起点
        path.moveTo(x, width / 2);
        //控制点的相对宽度
        int quadWidth = width / 4;
        //控制点的相对高度
        int quadHeight = width / 20 * 3;
        //第一个周期波形
        path.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);
        path.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        //第二个周期波形
        path.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);
        path.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        //右侧的直线
        path.lineTo(x + width * 2, width);
        //下边的直线
        path.lineTo(x, width);
        //自动闭合补出左边的直线
        path.close();
        return path;
    }

    private void drawCenterText(Canvas canvas, String text, float x, float y, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float top = fontMetrics.top;
        float bottom = fontMetrics.bottom;
        int centerY = (int) (y - top / 2 - bottom / 2);
        canvas.drawText(text, x, centerY, paint);
    }
}
