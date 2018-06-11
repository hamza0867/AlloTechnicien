package com.example.hamza.allotechnicien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class BaseActivity extends AppCompatActivity {

    RelativeLayout activityLayout;
    RelativeLayout.LayoutParams layoutParams;
    View contentView;
    public static String SERVER_URL = "http://192.168.1.14:8080/AlloTechnicienApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        activityLayout =  findViewById(R.id.activity_layout);
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
    }
}
