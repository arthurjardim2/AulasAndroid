package com.example.connectionvolley;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.example.connectionvolley.adapter.FotosAdapter;
import com.example.connectionvolley.connection.requests.ExampleRequest;


public class MainActivity extends ActionBarActivity implements Listener, ErrorListener{

	private ListView lvFotos;
	private FotosAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        adapter = new FotosAdapter(this, R.layout.imageview_volley, null);
        
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
	}
}
