package com.example.hamza.allotechnicien.clientActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class ProfileClientActivity extends BaseActivity {

    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_profile_client, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileClientActivity.this, ClientActivity.class);
            startActivity(intent);
        });
    }
}
