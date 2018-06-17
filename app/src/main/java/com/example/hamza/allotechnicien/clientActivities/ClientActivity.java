package com.example.hamza.allotechnicien.clientActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.hamza.allotechnicien.AccueilActivity;
import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.R;

public class ClientActivity extends BaseActivity {

    Button panneButton;
    Button profileButton;
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_client, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        panneButton = findViewById(R.id.panneButton);
        profileButton = findViewById(R.id.profileButton);
        returnButton = findViewById(R.id.returnButton);

        panneButton.setOnClickListener(v -> {
            Intent intent = new Intent(ClientActivity.this, DeclarerPanneActivity.class);
            startActivity(intent);
        });

        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(ClientActivity.this, AccueilActivity.class);
            startActivity(intent);
        });

        profileButton.setOnClickListener(v->{
            Intent intent = new Intent(ClientActivity.this, ProfileClientActivity.class);
            startActivity(intent);
        });
    }
}
