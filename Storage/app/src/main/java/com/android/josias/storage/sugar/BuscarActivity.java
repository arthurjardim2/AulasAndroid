package com.android.josias.storage.sugar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.josias.storage.R;
import com.android.josias.storage.sugar.models.Aluno;

import java.util.List;

public class BuscarActivity extends ActionBarActivity {

    private TextView tvResult;
    private EditText etMatricula, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        tvResult = (TextView)findViewById(R.id.tvResult);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void buscar(View v){

        tvResult.setText("");
        StringBuffer result = new StringBuffer();
        result.append("Resultado busca criteriosa:\n\n");

        String nome = etNome.getText().toString();
        String mat = etMatricula.getText().toString();

        List<Aluno> al = Aluno.find(Aluno.class, "nome = ? AND matricula = ?", nome, mat);
        for (Aluno a: al){
            result.append(a.getMatricula() + " - " +a.getNome() + " - " + a.getEmail()+"\n");
        }

        tvResult.setText(result.toString());
    }

    public void buscarTodos(View v){

        tvResult.setText("");
        StringBuffer result = new StringBuffer();
        result.append("Resultado do buscar todos:\n\n");

        List<Aluno> al = Aluno.listAll(Aluno.class);
        for (Aluno a: al){
            result.append(a.getMatricula() + " - " +a.getNome() + " - " + a.getEmail()+"\n");
        }

        tvResult.setText(result.toString());
    }


}
