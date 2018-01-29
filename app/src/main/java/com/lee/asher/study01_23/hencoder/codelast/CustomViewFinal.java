package com.lee.asher.study01_23.hencoder.codelast;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lihong on 2018/1/24.
 */

public class CustomViewFinal extends View {

    private Paint paint = new Paint();
    private Paint paint2;
    private RectF rectF = new RectF(300, 300, 600, 500);
    private boolean isAnimationRunning;
    private AnimatorSet animatorSet;
    private Path path;

    public CustomViewFinal(Context context) {
        super(context);
    }

    public CustomViewFinal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        paint2 = new Paint();
        paint2.setStrokeWidth(10);
        paint2.setColor(Color.BLUE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "strokeWidth", 1f, 50f);
        objectAnimator.setDuration(5000);

        animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator);

        path = new Path();
        path.moveTo(100, 100);
        path.quadTo(200, 200, 400, 100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawArc(rectF, 0, 90, false, paint);
//        //ObjectAnimator动画替换计数器
//        if (!isAnimationRunning) {
//            isAnimationRunning = true;
//            animatorSet.start();
//        }
        canvas.drawPath(path, paint);
    }

    public void setStrokeWidth(float strokeWidth) {
        paint.setStrokeWidth(strokeWidth);
        postInvalidate();
    }
}
