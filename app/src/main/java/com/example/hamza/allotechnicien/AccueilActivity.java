package com.example.hamza.allotechnicien;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AccueilActivity extends BaseActivity {

    Button clientButton;
    Button technicienButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_accueil, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        clientButton = findViewById(R.id.clientButton);
        technicienButton = findViewById(R.id.technicienButton);

        clientButton.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, ClientActivity.class);
            startActivity(intent);
        });

        technicienButton.setOnClickListener(v -> {
            Intent intent = new Intent(AccueilActivity.this, BaseActivity.class);
            startActivity(intent);
        });
    }
}
