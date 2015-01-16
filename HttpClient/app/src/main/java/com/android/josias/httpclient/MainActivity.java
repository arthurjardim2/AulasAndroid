package com.android.josias.httpclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAsync(View v){
        Intent i = new Intent(this, AsyncTaskActivity.class);
        startActivity(i);
    }

    public void openVolley(View v){
        Intent i = new Intent(this, VolleyActivity.class);
        startActivity(i);
    }

    public void openVolleyIL(View v){
        Intent i = new Intent(this, VolleyImageLoaderActivity.class);
        startActivity(i);
    }

}
