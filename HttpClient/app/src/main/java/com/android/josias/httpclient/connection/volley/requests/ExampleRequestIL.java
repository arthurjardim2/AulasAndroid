package com.android.josias.httpclient.connection.volley.requests;

import android.content.Context;

import com.android.josias.httpclient.VolleyImageLoaderActivity;
import com.android.josias.httpclient.connection.volley.ApplicationController;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Josias on 16/01/2015.
 */
public class ExampleRequestIL {
    private static final String URL =
            "http://www.eukip.com/aulas/feedeventos.html";

    private String resultRequest;

    public void requestImageGet(VolleyImageLoaderActivity main,  final Context context){

        //Conexão com serviço usando Volley
        RequestQueue queue = Volley.newRequestQueue(context);

        /**
         * Parametros de recebimento
         * @param metodo de requisição POST OU GET
         * @param metodo de requisição URL do Serviço
         * @param metodo de requisição Interface de tratamento de erro
         * @param metodo de requisição Interface para sucesso
         */
        StringRequest getRequest = new StringRequest(Request.Method.GET, URL, main, main);
        ApplicationController.getInstance().addToRequestQueue(getRequest);

    }

    public void requestImagePost(VolleyImageLoaderActivity main,  final Context context){

        //Conexão com servço usando Volley
        RequestQueue queue = Volley.newRequestQueue(context);

        /**
         * Parametros de recebimento
         * @param metodo de requisição POST OU GET
         * @param metodo de requisição URL do Serviço
         * @param metodo de requisição Interface de tratamento de erro
         * @param metodo de requisição Interface para sucesso
         */
        StringRequest postRequest = new StringRequest(Request.Method.POST,URL, main, main) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("param", "valor");
                params.put("param", "valor");

                return params;
            }
        };
        queue.add(postRequest);
    }

    public boolean jsonResult(Context context, String result){
        //TRATAMENTO DO JSON DE RETORNO
        return false;
    }
}

