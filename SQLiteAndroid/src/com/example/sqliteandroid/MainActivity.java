package com.example.sqliteandroid;

import java.util.ArrayList;

import com.example.sqliteandroid.persistence.dados.UserDAO;
import com.example.sqliteandroid.persistence.model.User;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private EditText etNome, etCod;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etNome = (EditText)findViewById(R.id.etNome);
        etCod = (EditText)findViewById(R.id.etCod);
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
    
    public void saveDB(View v){
    	
    	User u = new User();
    	u.setCod(etCod.getText().toString());
    	u.setNome(etNome.getText().toString());
    	
    	UserDAO udao = new UserDAO(MainActivity.this);
    	
    	if (udao.insert(u)) {
			Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
		}
    }
    
    public void buscarDB(View v){
    	UserDAO udao = new UserDAO(MainActivity.this);
    	ArrayList<User> users = udao.getAll();
    	
    	for (User user : users) {
			Log.i("teste", user.getCod() + " - " + user.getNome());
		}
    }
}
