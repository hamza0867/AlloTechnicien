package com.example.hamza.allotechnicien;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    EditText loginET, passwordET;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_main, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
        loginET = (EditText) findViewById(R.id.loginEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        String login = loginET.getText().toString();
        String password = passwordET.getText().toString();
        loginButton = (Button) findViewById(R.id.loginButton);
    }
}
