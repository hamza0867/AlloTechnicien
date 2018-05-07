package com.example.hamza.allotechnicien;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SubscribeActivity extends BaseActivity {

    EditText passwordET;
    EditText confirmPasswordET;
    EditText loginEditText;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.subscribe_activity_layout, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        loginEditText = (EditText) findViewById(R.id.loginET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        confirmPasswordET = (EditText) findViewById(R.id.confirmPasswordET);
        confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener((View v) -> {
            String login = loginEditText.getText().toString();
            String password = passwordET.getText().toString();
            String confirmPassword = confirmPasswordET.getText().toString();
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "les deux mots de passe donne ne sont pas les memes", Toast.LENGTH_SHORT).show();
                return;
            }
            String request = "http://192.168.1.14:8080/AlloTechnicienApp/Subscribe";
            String urlParameters = String.format("login=%s&password=%s", login, password);
            HttpPostAsyncTask task = new HttpPostAsyncTask(urlParameters, getApplicationContext());
            task.execute(request);
        });
    }

}
