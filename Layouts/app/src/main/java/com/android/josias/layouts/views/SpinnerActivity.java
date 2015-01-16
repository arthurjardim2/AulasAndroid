package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.josias.layouts.R;

public class SpinnerActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private TextView tvTitulo;
    private EditText etText;
    private Button btOk;
    private Spinner spinner;
    private String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        etText = (EditText) findViewById(R.id.etText);
        btOk = (Button) findViewById(R.id.btOk);

        spinner = (Spinner) findViewById(R.id.spLock);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void buttonClick(View v) {
        switch (selection){
            case "Liberar":
                String text = etText.getText().toString();
                tvTitulo.setText(text);
                etText.setText("");
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selection = parent.getItemAtPosition(position).toString();
        switch (selection){
            case "Liberar":
                Toast.makeText(this, "Liberado! :P", Toast.LENGTH_SHORT).show();
                break;
            case "Travar":
                Toast.makeText(this, "Você não vai conseguir! :)", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
