package com.example.connectionvolley;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.connectionvolley.adapter.Foto;
import com.example.connectionvolley.adapter.FotosAdapter;
import com.example.connectionvolley.connection.requests.ExampleRequest;


public class MainActivity extends ActionBarActivity implements Listener, ErrorListener{

	private ListView lvFotos;
	private FotosAdapter adapter;
	private ArrayList<Foto> fotos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        fotos = new ArrayList<Foto>();
        
        adapter = new FotosAdapter(MainActivity.this, R.layout.imageview_volley, fotos);
        
        lvFotos = (ListView)findViewById(R.id.lvFotos);
        lvFotos.setAdapter(adapter);
        
        ExampleRequest req = new ExampleRequest();
        req.requestImageGet(MainActivity.this, MainActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onErrorResponse(VolleyError error) {
		Log.i("teste", "ERROR!");
	}


	@Override
	public void onResponse(Object response) {
		Log.i("teste", response.toString());
		try {
			JSONArray root = new JSONArray((String)response);
			
			for (int i = 0; i < root.length(); i++) {
			
				Foto f = new Foto();
				f.setTitulo(root.getJSONObject(i).getString("evento"));
				f.setUrl(root.getJSONObject(i).getString("img"));
				
				fotos.add(f);
			}
			
			SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
			SharedPreferences.Editor editor = pref.edit();
			
			editor.putString("json", (String)response);
			
			editor.commit();
			
			adapter.notifyDataSetChanged();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getPref(View v){
		SharedPreferences pref =
		PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
		String titulo = pref.getString("json", null);
		
		Toast.makeText(MainActivity.this, titulo, Toast.LENGTH_SHORT).show();
	}
}
