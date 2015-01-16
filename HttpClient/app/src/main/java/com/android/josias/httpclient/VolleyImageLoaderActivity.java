package com.android.josias.httpclient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.android.josias.httpclient.adapters.ListViewAdapter;
import com.android.josias.httpclient.connection.volley.requests.ExampleRequestIL;
import com.android.josias.httpclient.models.Evento;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class VolleyImageLoaderActivity extends ActionBarActivity implements Response.Listener, Response.ErrorListener {

    private TextView tvResponse;
    private ListView lvFeed;
    private ListViewAdapter adapter;
    private ArrayList<Evento> eventos;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_image_loader);

        tvResponse = (TextView)findViewById(R.id.tvResponse);

        eventos = new ArrayList<Evento>();

        lvFeed = (ListView)findViewById(R.id.lvFeed);
        adapter = new ListViewAdapter(this, R.layout.itemlist_evento, eventos);
        lvFeed.setAdapter(adapter);

        progress = new ProgressDialog(this);
        progress.setMessage("Carregando ....");
        progress.show();

        ExampleRequestIL req = new ExampleRequestIL();
        req.requestImageGet(VolleyImageLoaderActivity.this, VolleyImageLoaderActivity.this);

    }
    @Override
    public void onErrorResponse(VolleyError error) {
        progress.dismiss();
        tvResponse.setText("Opa! Não foi em ... você tem conexão com a internet?");
    }

    @Override
    public void onResponse(Object response) {
        progress.dismiss();

        String result = response.toString();

        try {
            JSONArray root = new JSONArray((String)response);

            for (int i = 0; i < root.length(); i++) {
                Evento e = new Evento();
                e.setTitulo(root.getJSONObject(i).getString("evento"));
                e.setUrl(root.getJSONObject(i).getString("img"));

                eventos.add(e);
            }

            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
