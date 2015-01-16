package com.android.josias.layouts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.josias.layouts.adapters.ListViewAdapter;
import com.android.josias.layouts.models.Evento;

import java.util.ArrayList;


public class ListViewActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private ListView lv;
    private ListViewAdapter adapter;
    private ArrayList<Evento> eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        eventos = new ArrayList<Evento>();
        for (int i = 0; i < 20; i++) {
            eventos.add(new Evento("Evento " + (i+1), "Descrição aqui..."));
        }

        lv = (ListView)findViewById(R.id.lv);
        adapter = new ListViewAdapter(this, R.layout.itemlist_evento, eventos);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Evento e = adapter.getItem(position);
        Toast.makeText(this, e.getTitulo() + ": " + e.getDescricao(), Toast.LENGTH_SHORT).show();
    }
}
