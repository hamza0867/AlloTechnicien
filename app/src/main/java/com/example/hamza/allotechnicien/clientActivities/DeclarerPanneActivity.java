package com.example.hamza.allotechnicien.clientActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class DeclarerPanneActivity extends BaseActivity {

    private Button envoyerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_declarer_panne, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        envoyerButton = findViewById(R.id.envoyerButton);
        envoyerButton.setOnClickListener(v -> {
            Intent intent = new Intent( DeclarerPanneActivity.this, TechniciensDispoActivity.class);
            startActivity(intent);
        });
    }
}
