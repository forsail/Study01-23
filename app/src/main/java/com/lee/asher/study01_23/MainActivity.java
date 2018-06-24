package com.lee.asher.study01_23;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lee.asher.study01_23.hencoder.base.Utils;
import com.lee.asher.study01_23.hencoder.code3.CustomView3;
import com.lee.asher.study01_23.hencoder.codelast.SandClockView;

public class MainActivity extends AppCompatActivity {
    private int defaultX = 0, defaultY = Utils.dip2px(48) / 3, space = Utils.dip2px(32) / 8;
    private boolean isPlus = true;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        final ImageView text = (ImageView) findViewById(R.id.text);
//        text.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(text, "rotation", 0f, 90f);
//                objectAnimator.setDuration(100);
//                objectAnimator.start();
//            }
//        });
//        Test test = new Test();

//        final SandClockView sandClockView = (SandClockView) findViewById(R.id.custom);
//        final Button btnX = (Button) findViewById(R.id.x);
//        final Button btnY = (Button) findViewById(R.id.y);
//        final Button btnSpace = (Button) findViewById(R.id.space);
//        final Button btnStatus = (Button) findViewById(R.id.status);
//        btnX.setText("x:" + defaultX);
//        btnY.setText("y:" + defaultY);
//        btnSpace.setText("space:" + space);
//        btnX.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPlus) {
//                    defaultX++;
//                } else {
//                    defaultX--;
//                }
//
//                btnX.setText("x:" + defaultX);
//                sandClockView.setControlX(defaultX);
//                Log.d(TAG, "onClick:x " + defaultX);
//
//            }
//        });
//
//        btnY.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPlus) {
//                    defaultY++;
//                } else {
//                    defaultY--;
//                }
//
//                btnY.setText("y:" + defaultY);
//                sandClockView.setControlY(defaultY);
//                Log.d(TAG, "onClick:y " + defaultY);
//            }
//        });
//
//        btnSpace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPlus) {
//                    space++;
//                } else {
//                    space--;
//                }
//
//                btnSpace.setText("space:" + space);
//                sandClockView.setSpace(space);
//                Log.d(TAG, "onClick:space " + space);
//            }
//        });
//
//        btnStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isPlus = !isPlus;
//                if (isPlus) {
//                    btnStatus.setText("+");
//                } else {
//                    btnStatus.setText("-");
//                }
//            }
//        });
    }

    class Test {
        public int intValue;

        public void setIntValue(int intValue) {
            this.intValue = intValue;
            Log.d("test", intValue + "");
        }
    }
}
