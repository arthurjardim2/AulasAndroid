package com.example.appeventos.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appeventos.R;
import com.example.appeventos.adapters.model.Eventos;

public class FeedEventosAdapter extends ArrayAdapter<Eventos>{

	private ArrayList<Eventos> eventos;
	private LayoutInflater inflater;
	private Context context;
	
	public FeedEventosAdapter(Context context, int resource,
			ArrayList<Eventos> eventos) {
		super(context, resource, eventos);
		this.context = context;
		this.eventos = eventos;
		
		inflater = (LayoutInflater)
			context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Eventos e = eventos.get(position);
		
		EventosHolder holder;
		
		TextView tvTitulo;
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.itemlist_feed, null);
			
			tvTitulo = (TextView)convertView.findViewById(R.id.tvTitulo);
			
			holder = new EventosHolder();
			holder.tvTitulo = tvTitulo;
			
			convertView.setTag(holder);
		}else{
			holder = (EventosHolder) convertView.getTag();
			tvTitulo = holder.tvTitulo;
		}
		
		tvTitulo.setText(e.getTitulo());
		
		return convertView;
	}
	
	//Classe responsável por manter a referencias dos objetos
	private class EventosHolder{
		public TextView tvTitulo;
		public TextView tvData;
		public ImageView ivEvento;
	}

}
