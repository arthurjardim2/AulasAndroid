package com.example.appeventos;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.example.appeventos.adapters.FeedEventosAdapter;
import com.example.appeventos.adapters.model.Eventos;
import com.exemple.appeventos.connection.Connection;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity{

	private ListView lvFeed;
	private FeedEventosAdapter adapter;
	
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ActionBar
		configureActionBar();
		
		//Simulação dos eventos
		ArrayList<Eventos> eventos = new ArrayList<Eventos>();
		eventos.add(new Eventos("Evento 01", "22/08/2014", ""));
		eventos.add(new Eventos("Evento 02", "23/08/2014", ""));
		eventos.add(new Eventos("Evento 03", "24/08/2014", ""));
		eventos.add(new Eventos("Evento 04", "25/08/2014", ""));
		eventos.add(new Eventos("Evento 05", "26/08/2014", ""));
		eventos.add(new Eventos("Evento 06", "27/08/2014", ""));
		eventos.add(new Eventos("Evento 11", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 023", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 0342", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 074", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 0746", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 0756", "28/08/2014", ""));
		eventos.add(new Eventos("Evento 077", "28/08/2014", ""));
		
		//Instanciar Adapter antes da lista
		adapter = new FeedEventosAdapter(MainActivity.this,
				R.layout.itemlist_feed, eventos);
		
		lvFeed = (ListView)findViewById(R.id.lvFeed);
		lvFeed.setAdapter(adapter);
		
		
		new GetEventos().execute();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

	/**
	 * ActionBar
	 */
	private void configureActionBar() {
		// Hide title
		getSupportActionBar().setDisplayShowTitleEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		// Navigation drawer
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.apptheme_ic_navigation_drawer, R.string.empty, R.string.empty) {

			@Override
			public void onDrawerClosed(View view) {
				supportInvalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				supportInvalidateOptionsMenu();
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}
	
	public void openProfile(View v){
		//INTENT TROCA DE TELA
		//SWITCH SCREEN
		Intent i = new Intent(MainActivity.this, PerfilActivity.class);
		startActivity(i);
	}
	
	private class GetEventos extends AsyncTask<Void, Void, String>{

		//SÓ EXECUÇÃO DA CONEXÃO
		@Override
		protected String doInBackground(Void... params) {
				String result = Connection.sendRequestGet(
						"http://www.eukip.com/aulas/feedeventos.html");
			return result;
		}
		
		//TRATAMENTO DA RESPOSTA DA CONEXÃO
		@Override
		protected void onPostExecute(String result) {
			if (result != null) {
				Log.i("teste", result);
			}else{
				Log.i("teste", "NULO DEU MERDA");
			}
			
		}
		
	}
	
}

