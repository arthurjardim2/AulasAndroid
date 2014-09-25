package com.example.connectionvolley.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.volley.toolbox.NetworkImageView;
import com.example.connectionvolley.R;
import com.example.connectionvolley.connection.ApplicationController;

public class FotosAdapter extends ArrayAdapter<Foto>{

	private ArrayList<Foto> fotos;
	private LayoutInflater inflater;
	
	public FotosAdapter(Context context, int resource, ArrayList<Foto> fotos) {
		super(context, resource);
		this.fotos = fotos;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Foto f = fotos.get(position);
		
		NetworkImageView image;
		
		if (convertView == null) {
			
			convertView = inflater.inflate(R.layout.imageview_volley, null);
			
			image = (NetworkImageView)convertView.findViewById(R.id.image);
			
			Holder holder = new Holder();
			holder.image = image;
			
			convertView.setTag(holder);
			
		}else{
			
			Holder holder = (Holder)convertView.getTag();
			image = holder.image;
		}
		
		// Trecho 1
		image.setImageUrl(f.getUrl(), ApplicationController.getImageLoader());
		 
		return super.getView(position, convertView, parent);
	}
	
	private class Holder{
		private NetworkImageView image;
	}
	
}
