package com.example.hamza.allotechnicien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SubscribeActivity extends BaseActivity {

    EditText passwordET;
    EditText confirmPasswordET;
    EditText loginET;
    EditText nomET;
    EditText prenomET;
    EditText telephoneET;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.subscribe_activity_layout, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        loginET =  findViewById(R.id.loginET);
        passwordET =  findViewById(R.id.passwordET);
        confirmPasswordET =  findViewById(R.id.confirmPasswordET);
        nomET = findViewById(R.id.nomET);
        prenomET = findViewById(R.id.prenomET);
        telephoneET = findViewById(R.id.telephoneET);
        confirmButton =  findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener((View v) -> {
            /*String login = loginET.getText().toString();
            String password = passwordET.getText().toString();
            String confirmPassword = confirmPasswordET.getText().toString();
            String nom = nomET.getText().toString();
            String prenom = prenomET.getText().toString();
            String telephone = telephoneET.getText().toString();
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "les deux mots de passe donne ne sont pas les memes", Toast.LENGTH_SHORT).show();
                return;
            }
            String request = "/Subscribe";
            String urlParameters = String.format("login=%s&password=%s&nom=%s&prenom=%s&telephone=%s",
                    login, password, nom, prenom, telephone);
            HttpPostAsyncTask task = new HttpPostAsyncTask(urlParameters, getApplicationContext());
            task.execute(request);*/
            Intent intent = new Intent(SubscribeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

}
