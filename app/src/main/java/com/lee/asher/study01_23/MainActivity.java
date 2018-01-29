package com.lee.asher.study01_23;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    }

    class Test {
        public int intValue;

        public void setIntValue(int intValue) {
            this.intValue = intValue;
            Log.d("test", intValue + "");
        }
    }
}
