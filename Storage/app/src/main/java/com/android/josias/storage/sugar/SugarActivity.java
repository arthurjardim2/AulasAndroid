package com.android.josias.storage.sugar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.android.josias.storage.R;

public class SugarActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar);
    }


    public void openCadastrar(View v){
        Intent i = new Intent(this, CadastrarActivity.class);
        startActivity(i);
    }

    public void openAtualizar(View v){
        Intent i = new Intent(this, AtualizarActivity.class);
        startActivity(i);
    }

    public void openApagar(View v){
        Intent i = new Intent(this, ApagarActivity.class);
        startActivity(i);
    }

    public void openBuscar(View v){
        Intent i = new Intent(this, BuscarActivity.class);
        startActivity(i);
    }
}
