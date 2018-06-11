package com.example.hamza.allotechnicien.technicienActivities;

import android.os.Bundle;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class TechnicienActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_technicien, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
