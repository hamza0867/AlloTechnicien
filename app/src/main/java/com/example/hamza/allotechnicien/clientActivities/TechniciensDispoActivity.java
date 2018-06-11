package com.example.hamza.allotechnicien.clientActivities;

import android.os.Bundle;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class TechniciensDispoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.subscribe_activity_layout, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
