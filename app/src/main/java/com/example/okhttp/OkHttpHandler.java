package com.example.okhttp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by aruna on 1/7/18.
 */
class OkHttpHandler extends AsyncTask {

    OkHttpClient client = new OkHttpClient();

    Context context;

    public OkHttpHandler(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Request.Builder builder = new Request.Builder();
        builder.url(objects[0].toString());
        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        try {
            JSONArray ja = new JSONArray(o.toString());
            JSONObject jo = ja.getJSONObject(0);

            Toast.makeText(context,jo.toString(),Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
