package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.josias.layouts.R;

public class CheckBoxActivity extends ActionBarActivity {

    private TextView tvTitulo;
    private EditText etText;
    private Button btOk;
    private CheckBox cbLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        etText = (EditText)findViewById(R.id.etText);
        btOk = (Button)findViewById(R.id.btOk);
        cbLock = (CheckBox)findViewById(R.id.cbLock);
    }

    public void buttonClick(View v){
        if (!cbLock.isChecked()){
            String text = etText.getText().toString();
            tvTitulo.setText(text);
            etText.setText("");
        }
    }

    public void alertCheck(View v){
        if (cbLock.isChecked()){
            Toast.makeText(this, "Você não vai conseguir! :)", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Liberado! :P", Toast.LENGTH_SHORT).show();
        }
    }

}