package com.android.josias.storage.sugar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;
import com.android.josias.storage.sugar.models.Aluno;

public class CadastrarActivity extends ActionBarActivity {

    private EditText etMatricula, etNome, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
        etEmail = (EditText)findViewById(R.id.etEmail);
    }

    public void salvar(View v){

        String mat = etMatricula.getText().toString();
        String nome = etNome.getText().toString();
        String email = etEmail.getText().toString();

        Aluno aluno = new Aluno(mat, nome, email);
        aluno.save();
        Toast.makeText(this, "Cadastro realizado!", Toast.LENGTH_SHORT).show();
    }


}
