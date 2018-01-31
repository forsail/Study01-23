package com.lee.asher.study01_23.hencoder.code02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.DashPathEffect;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.lee.asher.study01_23.R;
import com.lee.asher.study01_23.hencoder.base.Utils;

/**
 * Created by lihong on 2018/1/29.
 */

public class CustomView2 extends View {
    private static final String TAG = "CustomView";

    private Paint paint = new Paint();
    private Paint paint2 = new Paint();
    private Paint paint3 = new Paint();
    private Paint paint4 = new Paint();
    private Paint paint5 = new Paint();
    private Paint paint6 = new Paint();
    private Paint paint7 = new Paint();
    private int width;

    public CustomView2(Context context) {
        super(context);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        width = Utils.getScreenWidth(getContext());
        paint5.setColor(Color.parseColor("#333333"));
        paint5.setTextSize(30);
        paint6.setColor(Color.parseColor("#333333"));
        paint6.setStrokeWidth(50);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        paint6.setTextSize(100);
        paint6.setStrokeJoin(Paint.Join.ROUND);//设置拐角

        paint7.setColor(Color.parseColor("#333333"));
        paint7.setStrokeWidth(1);
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
        paint.setTextSize(100);
        canvas.drawText("李宏", width / 3 * 2 + 20, 150 - top, paint);

        LinearGradient gradient = new LinearGradient(0, 400, 200, 400, Color.parseColor("#ff0000"),
                Color.parseColor("#0000ff"), Shader.TileMode.CLAMP);
        paint2.setShader(gradient);
        canvas.drawCircle(110, 400, 100, paint2);
        canvas.drawText("shader用法，LinearGradient渐变", 220, 400, paint5);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_jay);
        BitmapShader shader1 = new BitmapShader(bitmap1, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_batman_logo);
        BitmapShader shader2 = new BitmapShader(bitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        ComposeShader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_OVER);
        paint3.setShader(shader1);
        canvas.drawCircle(110, 700, 100, paint3);
        canvas.drawText("shader用法，BitmapShader", 220, 700, paint5);


        LightingColorFilter colorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        paint4.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap1, 10, 900, paint4);
        canvas.drawText("ColorFilter用法，LightingColorFilter", bitmap1.getWidth() + 20, 900 + bitmap1.getHeight() / 2, paint5);


        canvas.drawLine(10, 1000 + bitmap1.getHeight(), 200, 1000 + bitmap1.getHeight(), paint6);
        canvas.drawText("7", 10, 1150 + bitmap1.getHeight(), paint6);

//        setLayerType(LAYER_TYPE_SOFTWARE, null);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{20, 20}, 0);
        paint7.setPathEffect(dashPathEffect);
        canvas.drawLine(10, 1350 + bitmap1.getHeight(), 200, 1350 + bitmap1.getHeight(), paint7);

    }
}
