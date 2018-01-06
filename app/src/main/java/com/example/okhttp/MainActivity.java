package com.example.okhttp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client;
    String URL;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        client = new OkHttpClient();

        URL = "http://192.168.8.100/android/readContact.php";

    }


    public void onClick(View view) {
        try {
            OkHttpHandler okHttpHandler= new OkHttpHandler(context);
            okHttpHandler.execute(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

