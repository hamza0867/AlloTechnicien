package com.example.hamza.allotechnicien.clientActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.HttpPostAsyncTask;
import com.example.hamza.allotechnicien.R;
import com.example.hamza.allotechnicien.models.Demande;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeclarerPanneActivity extends BaseActivity {

    private Button envoyerButton;
    private EditText descriptifPanneET;
    private EditText adressET;
    private Spinner domaineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_declarer_panne, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        descriptifPanneET = findViewById(R.id.descriptifPanneET);
        adressET = findViewById(R.id.adresseET);
        domaineView = findViewById(R.id.typePanneSpinner);


        envoyerButton = findViewById(R.id.envoyerButton);
        envoyerButton.setOnClickListener(v -> {

            String descriptifPanne = descriptifPanneET.getText().toString();
            String adress = adressET.getText().toString();

            Demande demande = new Demande(descriptifPanne, adress);
            ObjectMapper mapper = new ObjectMapper();

            try {
                String jsonString = mapper.writeValueAsString(demande);
                HttpPostAsyncTask task = new HttpPostAsyncTask(jsonString);
                task.execute("/demandes/ajout/3/0");
                String result = null;
                while (result == null){
                    result = task.getResult();
                }
                if (result.equalsIgnoreCase("OK")){
                    Intent intent = new Intent( DeclarerPanneActivity.this, TechniciensDispoActivity.class);
                    startActivity(intent);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();

            }

        });
    }
}
