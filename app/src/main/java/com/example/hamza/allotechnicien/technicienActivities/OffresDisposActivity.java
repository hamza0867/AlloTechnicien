package com.example.hamza.allotechnicien.technicienActivities;

import android.os.Bundle;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class OffresDisposActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_offres_dispos, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
