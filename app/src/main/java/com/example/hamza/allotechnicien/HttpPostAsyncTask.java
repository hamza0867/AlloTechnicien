package com.example.hamza.allotechnicien;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpPostAsyncTask extends AsyncTask<String, Void, String> {

    private String urlParameters;
    private Context context;
    private String result;

    public HttpPostAsyncTask(String urlParameters, Context context){
        this.urlParameters = urlParameters;
        this.context = context;
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
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            try( OutputStreamWriter wr = new OutputStreamWriter( conn.getOutputStream())) {
                wr.write(urlParameters);
                wr.flush();
                wr.close();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            result = in.readLine();
            in.close();
            return result;
        } catch (MalformedURLException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

    public String getResult() {
        return result;
    }
}
