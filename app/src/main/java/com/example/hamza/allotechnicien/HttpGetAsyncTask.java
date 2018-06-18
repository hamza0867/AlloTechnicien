package com.example.hamza.allotechnicien;

import android.os.AsyncTask;

import com.example.hamza.allotechnicien.models.Technicien;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class HttpGetAsyncTask extends AsyncTask<String, Void, String> {

    private List<Technicien> jsonData;
    private String result;
    private String token;

    public HttpGetAsyncTask(){
        this.result = null;
        this.token = null;
        this.jsonData = null;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(BaseActivity.SERVER_URL + params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            if (BaseActivity.getToken() != null){
                conn.setRequestProperty("Authorization", BaseActivity.getToken());
            }
            conn.setUseCaches(false);
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                result = "OK";
                if (BaseActivity.getToken() == null) {
                    token = conn.getHeaderField("Authorization");
                }
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                ObjectMapper mapper = new ObjectMapper();
                Technicien[] arrayTech = mapper.readValue(bis, Technicien[].class);
                jsonData = Arrays.asList(arrayTech);

                return result;
            }

        } catch (MalformedURLException e) {
            result = "ERROR";
        } catch (IOException e) {
            result = "ERROR";
        }
        return result;
    }

    public List<Technicien> getJsonData(){
        return jsonData;
    }
}
