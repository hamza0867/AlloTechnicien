package com.example.hamza.allotechnicien;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.subscribe_activity_layout, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
