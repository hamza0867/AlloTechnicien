package com.example.hamza.allotechnicien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    EditText loginET, passwordET;
    TextView subscribeTV;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_main, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);
        loginET =  findViewById(R.id.loginEditText);
        passwordET =  findViewById(R.id.passwordEditText);
        loginButton =  findViewById(R.id.loginButton);
        subscribeTV =  findViewById(R.id.subscribeTextView);
        subscribeTV.setOnClickListener((View v)->{
            Intent intent = new Intent(this, SubscribeActivity.class);
            startActivity(intent);
        });
        loginButton.setOnClickListener((View v)->{


            /*String login = loginET.getText().toString();
            String password = passwordET.getText().toString();
            String urlParameters = String.format("login=%s&password=%s", login, password);
            HttpPostAsyncTask task = new HttpPostAsyncTask(urlParameters, getApplicationContext());
            task.execute("/Login");
            String result = null;
            while (result == null){
                result = task.getResult();
            }
            if(result.equalsIgnoreCase("OK")){
                Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                startActivity(intent);
            }*/

            Intent intent = new Intent(MainActivity.this, AccueilActivity.class );
            startActivity(intent);

        });
    }
}
