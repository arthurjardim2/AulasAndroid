package com.android.josias.storage.sugar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;
import com.android.josias.storage.sugar.models.Aluno;

import java.util.List;

public class AtualizarActivity extends ActionBarActivity {

    private EditText etMatricula, etNovoNome, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNovoNome = (EditText)findViewById(R.id.etNovoNome);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void atualizar(View v){

        String nome = etNome.getText().toString();
        String mat = etMatricula.getText().toString();
        String newNome = etNovoNome.getText().toString();

        List<Aluno> al = Aluno.find(Aluno.class, "nome = ? AND matricula = ?", nome, mat);
        for (Aluno a: al){
            a.setNome(newNome);
            a.save();
            Toast.makeText(this, a.getMatricula() + " foi atualizada.", Toast.LENGTH_SHORT).show();
        }
    }
}
