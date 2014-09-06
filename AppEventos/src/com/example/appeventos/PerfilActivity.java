package com.example.appeventos;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class PerfilActivity extends ActionBarActivity{

	private EditText etNome;
	private CheckBox cbTeste01;
	private ProgressBar pb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		etNome = (EditText)findViewById(R.id.etNome);
		cbTeste01 = (CheckBox)findViewById(R.id.cbTeste01);
		pb = (ProgressBar)findViewById(R.id.pb);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
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
	
	public void acaoSalvar(View v){
		
		if (cbTeste01.isChecked()) {
			pb.setVisibility(View.GONE);
		}else{
			pb.setVisibility(View.VISIBLE);
		}
	}
	public void acaoCancelar(View v){
		Toast.makeText(PerfilActivity.this, "CANCELAR",
				Toast.LENGTH_LONG).show();
	}
}
