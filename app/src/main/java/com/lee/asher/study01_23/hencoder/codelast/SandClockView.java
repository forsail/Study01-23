package com.lee.asher.study01_23.hencoder.codelast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lee.asher.study01_23.hencoder.base.Utils;

/**
 * Created by lihong on 2018/2/1.
 */

public class SandClockView extends View {

    private int width, height;
    private Paint linePaint, curvePaint, timePaint;

    private int controlX, controlY;
    private int space;

    public SandClockView(Context context) {
        super(context);
        init();
    }

    public SandClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.WHITE);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(4);

        curvePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        curvePaint.setColor(Color.WHITE);
        curvePaint.setStyle(Paint.Style.STROKE);
        curvePaint.setStrokeWidth(2);

        timePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        timePaint.setColor(Color.WHITE);
        timePaint.setStyle(Paint.Style.FILL);
        timePaint.setStrokeCap(Paint.Cap.ROUND);
        timePaint.setDither(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = Utils.dip2px(32);
        }
        height = width / 2 * 3;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, width, 0, linePaint);
        canvas.drawPath(getLeftPath(), curvePaint);
        canvas.drawLine(0, height, width, height, linePaint);
        canvas.drawPath(getRightPath(), curvePaint);
    }

    private Path getLeftPath() {
        Path path = new Path();
        path.lineTo(space, 0);
        path.quadTo(controlX, controlY, width / 16 * 7, height / 24 * 11);
        path.rLineTo(0, height / 12);
        path.quadTo(controlX, height - controlY, space, height);
        return path;
    }

    private Path getRightPath() {
        Path path = new Path();
        path.lineTo(width - space, 0);
        path.quadTo(width - controlX, controlY, width / 16 * 9, height / 24 * 11);
        path.rLineTo(0, height / 12);
        path.quadTo(width - controlX, height - controlY, width - space, height);
        return path;
    }

    public void setControlX(int controlX) {
        this.controlX = controlX;
        invalidate();
    }

    public void setControlY(int controlY) {
        this.controlY = controlY;
        invalidate();
    }

    public void setSpace(int space) {
        this.space = space;
        invalidate();
    }
}
