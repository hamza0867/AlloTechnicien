package com.example.hamza.allotechnicien;

import android.os.Bundle;

public class DeclarerPanneActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_declarer_panne, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
    }
}
