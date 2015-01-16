package com.android.josias.httpclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.josias.httpclient.R;
import com.android.josias.httpclient.connection.volley.ApplicationController;
import com.android.josias.httpclient.models.Evento;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by Josias on 15/01/2015.
 */
public class ListViewAdapter extends ArrayAdapter<Evento> {

    private ArrayList<Evento> eventos;
    private LayoutInflater inflater;
    private Context context;

    private ImageLoader mImageLoader;

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
        NetworkImageView mNetworkImageView;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemlist_evento, null);

            tvTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            tvDescricao = (TextView) convertView.findViewById(R.id.tvDescricao);

            mNetworkImageView = (NetworkImageView) convertView.findViewById(R.id.networkImageView);

            holder = new EventosHolder();
            holder.tvTitulo = tvTitulo;
            holder.tvDescricao = tvDescricao;
            holder.mNetworkImageView = mNetworkImageView;

            convertView.setTag(holder);
        } else {
            holder = (EventosHolder) convertView.getTag();
            tvTitulo = holder.tvTitulo;
            tvDescricao = holder.tvDescricao;
            mNetworkImageView = holder.mNetworkImageView;
        }

        tvTitulo.setText(e.getTitulo());

        mImageLoader = ApplicationController.getImageLoader();
        mNetworkImageView.setImageUrl(e.getUrl(), mImageLoader);

        return convertView;
    }

    //Classe responsável por manter a referencias dos objetos
    private class EventosHolder {
        public TextView tvTitulo;
        public TextView tvDescricao;
        public NetworkImageView mNetworkImageView;
    }
}
