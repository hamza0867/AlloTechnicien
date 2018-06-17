package com.example.hamza.allotechnicien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.hamza.allotechnicien.models.Utilisateur;

public class BaseActivity extends AppCompatActivity {

    protected RelativeLayout activityLayout;
    protected RelativeLayout.LayoutParams layoutParams;
    protected View contentView;
    public static String SERVER_URL = "http://192.168.1.19:8084";
    private static long utilisateurId;
    private static Utilisateur utilisateur;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        activityLayout =  findViewById(R.id.activity_layout);
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
    }

    public static void setUtilisateurId(long utilisateurId) {
        BaseActivity.utilisateurId = utilisateurId;
    }

    public static long getUtilisateurId(){
        return utilisateurId;
    }

    public static Utilisateur getUtilisateur(){
        return utilisateur;
    }

    public static void setUtilisateur(Utilisateur utilisateurToSet){
        utilisateur = utilisateurToSet;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        BaseActivity.token = token;
    }
}
