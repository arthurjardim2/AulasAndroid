package com.android.josias.storage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.android.josias.storage.sugar.SugarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSugar(View v){
        Intent i = new Intent(this, SugarActivity.class);
        startActivity(i);
    }

}
