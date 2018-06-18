package com.example.hamza.allotechnicien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hamza.allotechnicien.models.Utilisateur;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


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
            String login = loginET.getText().toString();
            String password = passwordET.getText().toString();
            String confirmPassword = confirmPasswordET.getText().toString();
            String nom = nomET.getText().toString();
            String prenom = prenomET.getText().toString();
            String telephone = telephoneET.getText().toString();
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getApplicationContext(), "les deux mots de passe donne ne sont pas les memes", Toast.LENGTH_SHORT).show();
                return;
            }
            Utilisateur utilisateur = new Utilisateur(login, password, nom, prenom, telephone);
            BaseActivity.setUtilisateurId(0);
            ObjectMapper mapper = new ObjectMapper();
            try {
                String jsonString = mapper.writeValueAsString(utilisateur);
                String request = "/utilisateurs/inscription";
                HttpPostAsyncTask task = new HttpPostAsyncTask(jsonString);
                task.execute(request);
                String result = null;
                while (result == null){
                    result = task.getResult();
                }
                if (result.equalsIgnoreCase("OK")){

                    try {
                        JsonNode rootNode = mapper.createObjectNode();
                        ((ObjectNode) rootNode).put("email", login);
                        ((ObjectNode) rootNode).put("password", password);
                        jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
                    } catch (Exception e){
                    }
                    HttpPostAsyncTask task2 = new HttpPostAsyncTask(jsonString);
                    task2.execute("/login");
                    String result2 = null;
                    while (result2 == null){
                        result2 = task2.getResult();
                    }
                    if (result2.equalsIgnoreCase("OK")){
                        do{
                            task2.getToken();
                        }while (task2.getToken() == null);
                        BaseActivity.setToken(task2.getToken());
                        Intent intent = new Intent(SubscribeActivity.this, AccueilActivity.class);
                        startActivity(intent);
                    }
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

}
