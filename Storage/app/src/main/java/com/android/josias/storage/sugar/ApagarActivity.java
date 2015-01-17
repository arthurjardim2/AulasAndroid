package com.android.josias.storage.sugar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.josias.storage.R;
import com.android.josias.storage.sugar.models.Aluno;

import java.util.List;

public class ApagarActivity extends ActionBarActivity {

    private EditText etMatricula, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apagar);

        etMatricula = (EditText)findViewById(R.id.etMatricula);
        etNome = (EditText)findViewById(R.id.etNome);
    }

    public void apagar(View v){

        String nome = etNome.getText().toString();
        String mat = etMatricula.getText().toString();

        List<Aluno> al = Aluno.find(Aluno.class, "nome = ? AND matricula = ?", nome, mat);
        for (Aluno a: al){
            a.delete();
            Toast.makeText(this, a.getMatricula() + " foi apagado.", Toast.LENGTH_SHORT).show();
        }
    }
}
