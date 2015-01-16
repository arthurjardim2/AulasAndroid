package com.android.josias.httpclient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.android.josias.httpclient.connection.volley.requests.ExampleRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;


public class VolleyActivity extends ActionBarActivity implements Response.Listener, Response.ErrorListener {

    private TextView tvResponse;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        tvResponse = (TextView)findViewById(R.id.tvResponse);

        progress = new ProgressDialog(this);
        progress.setMessage("Carregando ....");
        progress.show();

        ExampleRequest req = new ExampleRequest();
        req.requestImageGet(VolleyActivity.this, VolleyActivity.this);

    }
    @Override
    public void onErrorResponse(VolleyError error) {
        progress.dismiss();
        tvResponse.setText("Opa! Não foi em ... você tem conexão com a internet?");
    }

    @Override
    public void onResponse(Object response) {
        progress.dismiss();
        tvResponse.setText(response.toString());
    }

}
