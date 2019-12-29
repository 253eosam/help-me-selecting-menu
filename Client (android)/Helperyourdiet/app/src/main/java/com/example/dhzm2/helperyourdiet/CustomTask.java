package com.example.dhzm2.helperyourdiet;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dhzm2 on 2018-05-02.
 */

class CustomTask extends AsyncTask<String, Void, String> {
    String sendMsg, receiveMsg;
    String URL;
    String tempURL;
    String jspURL;

    CustomTask(String jspURL){
        tempURL = "http://121.151.244.47:8080/helperYourDiet/";
        this.jspURL = jspURL;
        URL = tempURL + jspURL;
        receiveMsg = "";
        sendMsg = "";
    }
    public String getURL (){
        return URL;
    }
    @Override
    protected void onCancelled(String result){
        super.onCancelled();
        Log.e(this.getClass().getName(), "test 비동기테스크 종료 : " + result);
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            Log.e(this.getClass().getName(), "test 비동기테스크 시작 : " + strings[0]);
            String str;
            URL url = new URL(getURL());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");

            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
        //   sendMsg = "id=" + strings[0] + "&pwd=" + strings[1];
            sendMsg = strings[0];
            osw.write(sendMsg);
            osw.flush();
            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "EUC-KR");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();

            } else {
                Log.i("통신 결과", conn.getResponseCode() + "에러");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveMsg;
    }
}