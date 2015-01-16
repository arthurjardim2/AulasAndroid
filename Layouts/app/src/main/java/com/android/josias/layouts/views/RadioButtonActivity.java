package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.josias.layouts.R;

public class RadioButtonActivity extends ActionBarActivity {

    private TextView tvTitulo;
    private EditText etText;
    private Button btOk;
    private RadioGroup rbGroup;
    private RadioButton rb01, rb02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        etText = (EditText)findViewById(R.id.etText);
        btOk = (Button)findViewById(R.id.btOk);
        rbGroup = (RadioGroup)findViewById(R.id.rbGroup);
        rb01 = (RadioButton)findViewById(R.id.rb01);
        rb02 = (RadioButton)findViewById(R.id.rb02);
    }

    public void buttonClick(View v){

        if (rbGroup.getCheckedRadioButtonId() == R.id.rb01){
            String text = etText.getText().toString();
            tvTitulo.setText(text);
            etText.setText("");
        }
    }

    public void alertCheck(View v){
        if (rb01.isChecked()){
            Toast.makeText(this, "Liberado! :P", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Você não vai conseguir! :)", Toast.LENGTH_SHORT).show();
        }
    }

}