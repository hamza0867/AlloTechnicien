package com.example.hamza.allotechnicien;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.subscribe_activity_layout, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
