package com.chan.coordinatorbehaviordemo;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Demo1Activity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_demo1);

        tv1 = (TextView) findViewById(R.id.tv1);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 每次点击移动tv1
                ViewCompat.offsetTopAndBottom(v, 50);
            }
        });
    }
}
