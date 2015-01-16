package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.josias.layouts.R;

public class TextViewEditTextButtonActivity extends ActionBarActivity {

    private TextView tvTitulo;
    private EditText etText;
    private Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_ed_button);

        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        etText = (EditText)findViewById(R.id.etText);
        btOk = (Button)findViewById(R.id.btOk);
    }

    public void buttonClick(View v){
        String text = etText.getText().toString();
        tvTitulo.setText(text);
        etText.setText("");
    }

}
