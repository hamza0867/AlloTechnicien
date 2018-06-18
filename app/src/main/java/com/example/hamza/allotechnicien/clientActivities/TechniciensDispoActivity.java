package com.example.hamza.allotechnicien.clientActivities;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hamza.allotechnicien.BaseActivity;
import com.example.hamza.allotechnicien.HttpGetAsyncTask;
import com.example.hamza.allotechnicien.R;
import com.example.hamza.allotechnicien.models.Technicien;

import java.util.List;

public class TechniciensDispoActivity extends BaseActivity {

    private ListView techniciensDisposLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        contentView = getLayoutInflater().inflate(R.layout.activity_techniciens_dispo, null);
        contentView.setLayoutParams(layoutParams);
        activityLayout.addView(contentView);

        techniciensDisposLV = findViewById(R.id.techniciensDiposListView);

        List<Technicien> technicienList = null;
        HttpGetAsyncTask task = new HttpGetAsyncTask();
        task.execute("/techniciens");
        do {
            technicienList = task.getJsonData();
        } while (technicienList == null);
        TechniciensListAdapter adapter = new TechniciensListAdapter(this, technicienList);
        techniciensDisposLV.setAdapter(adapter);


    }
}
