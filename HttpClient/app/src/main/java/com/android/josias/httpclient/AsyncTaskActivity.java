package com.android.josias.httpclient;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.android.josias.httpclient.connection.async.Connection;


public class AsyncTaskActivity extends ActionBarActivity {

    private TextView tvResponse;

    private RequestService request;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        tvResponse = (TextView)findViewById(R.id.tvResponse);

        progress = new ProgressDialog(this);
        progress.setMessage("Carregando ....");
        progress.show();

        request = new RequestService();
        request.execute();
    }

    private class RequestService extends AsyncTask<Void, Void, String>{

        //EXECUÇÃO DA CONEXÃO
        @Override
        protected String doInBackground(Void... params) {
            String result = Connection.sendRequestGet(
                    "http://www.eukip.com/aulas/feedeventos.html");
            return result;
        }

        //TRATAMENTO DA RESPOSTA DA CONEXÃO
        @Override
        protected void onPostExecute(String result) {
            progress.dismiss();
            if (result != null) {
                tvResponse.setText(result);
            }else{
                tvResponse.setText("Opa! Não foi em ... você tem conexão com a internet?");
            }
        }
    }

}
