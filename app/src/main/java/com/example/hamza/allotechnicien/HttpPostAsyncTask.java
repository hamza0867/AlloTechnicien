package com.example.hamza.allotechnicien;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {

    private String jsonData;
    private String result;
    private String token;


    public HttpPostAsyncTask(String jsonData){
        this.jsonData = jsonData;
        this.result = null;
        this.token = null;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(BaseActivity.SERVER_URL + params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            if (BaseActivity.getToken() != null){
                conn.setRequestProperty("Authorization", BaseActivity.getToken());
            }
            conn.setUseCaches(false);
            try( OutputStream wr = conn.getOutputStream()) {
                wr.write(jsonData.getBytes("UTF-8"));
                wr.flush();
                wr.close();
            }
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                result = "OK";
                if (BaseActivity.getToken() == null) {
                    token = conn.getHeaderField("Authorization");
                }
                return result;
            }

        } catch (MalformedURLException e) {
            result = "ERROR";
        } catch (IOException e) {
            result = "ERROR";
        }
        return result;
    }

    public String getResult() {
        return result;
    }

    public String getToken() {
        return token;
    }
}
