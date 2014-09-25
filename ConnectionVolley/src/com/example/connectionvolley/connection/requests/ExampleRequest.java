package com.example.connectionvolley.connection.requests;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.connectionvolley.MainActivity;
import com.example.connectionvolley.connection.ApplicationController;

public class ExampleRequest{

	private static final String URL =
	"http://www.eukip.com/aulas/feedeventos.html";
	
	private String resultRequest;

	public void requestImageGet(MainActivity main,  final Context context){

		//Conex�o com servi�o usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisi��o POST OU GET
		 * @param metodo de requisi��o URL do Servi�o
		 * @param metodo de requisi��o Interface de tratamento de erro
		 * @param metodo de requisi��o Interface para sucesso
		 */
		StringRequest getRequest = new StringRequest(Request.Method.GET, URL, main, main);
		ApplicationController.getInstance().addToRequestQueue(getRequest); 

		
	}
	
	public void requestImagePost(MainActivity main,  final Context context){

		//Conex�o com servi�o usando Volley
		RequestQueue queue = Volley.newRequestQueue(context);

		/**
		 * Parametros de recebimento
		 * @param metodo de requisi��o POST OU GET
		 * @param metodo de requisi��o URL do Servi�o
		 * @param metodo de requisi��o Interface de tratamento de erro
		 * @param metodo de requisi��o Interface para sucesso
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
