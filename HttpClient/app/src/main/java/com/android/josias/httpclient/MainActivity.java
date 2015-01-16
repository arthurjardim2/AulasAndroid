package com.android.josias.httpclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.android.josias.httpclient.connection.requests.ExampleRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;


public class MainActivity extends ActionBarActivity implements Response.Listener, Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExampleRequest req = new ExampleRequest();
        req.requestImageGet(MainActivity.this, MainActivity.this);
    }

    public void openAsync(View v){

    }

    public void openVolley(View v){

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.i("teste", "ERROR!");
    }

    @Override
    public void onResponse(Object response) {
        Log.i("teste", response.toString());
        /*try {
            JSONArray root = new JSONArray((String)response);

            for (int i = 0; i < root.length(); i++) {

            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
