package com.example.hamza.allotechnicien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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


            String login = loginET.getText().toString();
            String password = passwordET.getText().toString();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = "";
            try {
                JsonNode rootNode = mapper.createObjectNode();
                ((ObjectNode) rootNode).put("email", login);
                ((ObjectNode) rootNode).put("password", password);
                jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            } catch (Exception e){
            }
            HttpPostAsyncTask task = new HttpPostAsyncTask(jsonString);
            task.execute("/login");
            String result = null;
            while (result == null){
                result = task.getResult();
            }
            if (result.equalsIgnoreCase("OK")){
                do{
                    task.getToken();
                }while (task.getToken() == null);
                BaseActivity.setToken(task.getToken());
                Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                BaseActivity.setUtilisateurId(-1);
                startActivity(intent);
            }

        });
    }
}
