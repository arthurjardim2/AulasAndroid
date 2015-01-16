package com.android.josias.layouts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.josias.layouts.R;
import com.android.josias.layouts.models.Evento;

import java.util.ArrayList;

/**
 * Created by Josias on 15/01/2015.
 */
public class ListViewAdapter extends ArrayAdapter<Evento> {

    private ArrayList<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;

    public ListViewAdapter(Context context, int resource, ArrayList<Evento> eventos) {
        super(context, resource, eventos);

        this.context = context;
        this.eventos = eventos;

        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Evento e = eventos.get(position);

        EventosHolder holder;

        TextView tvTitulo;
        TextView tvDescricao;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.itemlist_evento, null);

            tvTitulo = (TextView)convertView.findViewById(R.id.tvTitulo);
            tvDescricao = (TextView)convertView.findViewById(R.id.tvDescricao);

            holder = new EventosHolder();
            holder.tvTitulo = tvTitulo;
            holder.tvDescricao = tvDescricao;

            convertView.setTag(holder);
        }else{
            holder = (EventosHolder) convertView.getTag();
            tvTitulo = holder.tvTitulo;
            tvDescricao = holder.tvDescricao;
        }

        tvTitulo.setText(e.getTitulo());

        return convertView;
    }

    //Classe responsável por manter a referencias dos objetos
    private class EventosHolder{
        public TextView tvTitulo;
        public TextView tvDescricao;
    }
}
