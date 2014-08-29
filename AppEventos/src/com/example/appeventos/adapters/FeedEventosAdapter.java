package com.example.appeventos.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.appeventos.R;
import com.example.appeventos.adapters.model.Eventos;

public class FeedEventosAdapter extends ArrayAdapter<Eventos>{

	private ArrayList<Eventos> eventos;
	private LayoutInflater inflater;
	
	public FeedEventosAdapter(Context context, int resource,
			ArrayList<Eventos> eventos) {
		super(context, resource, eventos);
		
		this.eventos = eventos;
		
		inflater = (LayoutInflater)
			context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Eventos e = eventos.get(position);
		
		TextView tvTitulo;
		TextView tvData;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.itemlist_feed, null);
			
			tvTitulo = (TextView)convertView.findViewById(R.id.tvTitulo);
			tvData = (TextView)convertView.findViewById(R.id.tvData);
			
			//PARTE 01 - QUANDO CONVERTVIEW FOR NULL
			//Criação do holder para manter a ref. dos objetos
			EventosHolder evHolder = new EventosHolder();
			//Recebe os valores para manter a ref.
			evHolder.tvTitulo = tvTitulo;
			evHolder.tvData = tvData;
			
			//CV recebe TAG como sendo o holder
			convertView.setTag(evHolder);
		}else{
			
			//PARTE 02 - QUANDO CONVERTVIEW JÁ TIVER INFORMAÇÕES MANTIDAS
			//PELO HOLDER
			//Capturar o holder
			EventosHolder evHolder = (EventosHolder)convertView.getTag();
			//Jogar as informações do holder nos componentes
			tvTitulo = evHolder.tvTitulo;
			tvData = evHolder.tvData;
		}
		
		tvTitulo.setText(e.getTitulo());
		tvData.setText(e.getData());
		
		return convertView;
	}
	
	//Classe responsável por manter a referencias dos objetos
	private class EventosHolder{
		public TextView tvTitulo;
		public TextView tvData;
	}

}
