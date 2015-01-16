package com.android.josias.layouts;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class DialogsActivity extends ActionBarActivity {

    private AlertDialog.Builder dialog;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        progress = new ProgressDialog(this);
        dialog = new AlertDialog.Builder(this);
    }

    public void showToast(View v) {
        Toast.makeText(this, "Vocês já me conhecem! Não é?!", Toast.LENGTH_SHORT).show();
    }

    public void showAlert(View v) {
        dialog.setTitle("AlertDialog");
        dialog.setMessage("Opa Mensagem!");
        dialog.show();
    }

    public void showAlertButton(View v) {
        dialog.setTitle("AlertDialog");
        dialog.setMessage("Opa Mensagem!");
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNeutralButton("Neutro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void showProgress(View v) {
        progress.setTitle("Progress Dialog");
        progress.setMessage("Tá carregando ai ...");
        progress.show();
    }

}
