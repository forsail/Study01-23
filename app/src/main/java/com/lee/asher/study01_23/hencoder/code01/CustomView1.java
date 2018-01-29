package com.lee.asher.study01_23.hencoder.code01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by lihong on 2018/1/25.
 */

public class CustomView1 extends View {

    private static final String TAG = "CustomView";

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();

    public CustomView1(Context context) {
        super(context);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(50);
        paint.setStyle(Paint.Style.FILL);
        //设置线段的端点的形状
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);

        paint2.setColor(Color.YELLOW);
        paint2.setStrokeWidth(10);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setAntiAlias(true);
    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
                Log.d(TAG, "getMySize: UNSPECIFIED");
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
                //我们将大小取最大值,你也可以取其他值
                Log.d(TAG, "getMySize: AT_MOST");
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
                Log.d(TAG, "getMySize: EXACTLY");
                mySize = defaultSize;
                break;
            }
        }
        return mySize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(500, widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);
        Log.d(TAG, "onMeasure: " + width);
        Log.d(TAG, "onMeasure: " + height);
        width = Math.max(width, height);
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        Log.d(TAG, "onDraw: " + width);
        canvas.drawPoint(paint.getStrokeWidth(), paint.getStrokeWidth(), paint);
        float[] points = {width, 0, 0, width, width, width};
        canvas.drawPoints(points, 0, points.length, paint);
        canvas.drawCircle(width / 4 * 3, width / 4 * 3, width / 4, paint);

        RectF rect = new RectF(paint.getStrokeWidth() * 2, paint.getStrokeWidth() * 2, width / 2, width / 2);
        canvas.drawArc(rect, 0, 60, true, paint);
        canvas.drawArc(rect, 70, 60, false, paint);

        canvas.drawArc(rect, 140, 60, true, paint2);
        canvas.drawArc(rect, 210, 60, false, paint2);

        Path path = new Path();
//        path.addCircle(width / 4, width / 4 * 3, 30, Path.Direction.CW);
        int radius = 30;
//        path.moveTo(width / 4 - radius - radius / 1.41f, width / 4 * 3 + radius / 1.414f);

        //两个addArc之间是断开的path，如果不想线断开而可以使用path.close封闭图形的话，需要使用arcTo并且forceMove传false
        RectF rectF1 = new RectF(width / 4 - 2 * radius, width / 4 * 3 - radius, width / 4, width / 4 * 3 + radius);
        path.addArc(rectF1, 135, 225);
        RectF rectF2 = new RectF(width / 4, width / 4 * 3 - radius, width / 4 + 2 * radius, width / 4 * 3 + radius);
        path.arcTo(rectF2, 180, 225, false);
        path.lineTo(width / 4, width / 4 * 3 + 2.5f * radius);
        path.lineTo(width / 4 - radius - radius / 1.41f, width / 4 * 3 + radius / 1.414f);
//        path.close();
        canvas.drawPath(path, paint);
    }
}
