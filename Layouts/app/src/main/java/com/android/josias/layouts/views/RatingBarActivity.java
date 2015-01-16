package com.android.josias.layouts.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.android.josias.layouts.R;

public class RatingBarActivity extends ActionBarActivity {

    private RatingBar rbStar;
    private EditText et01, et02, et03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        rbStar = (RatingBar)findViewById(R.id.rbStar);
        et01 = (EditText)findViewById(R.id.et01);
        et02 = (EditText)findViewById(R.id.et02);
        et03 = (EditText)findViewById(R.id.et03);
    }

    public void config(View v){
        String et1 = et01.getText().toString();
        String et2 = et02.getText().toString();
        String et3 = et03.getText().toString();
        if (!et1.equals("") && !et2.equals("") && !et3.equals("")){
            int numStar = Integer.parseInt(et1);
            float numDefault = Float.parseFloat(et2);
            int tamPasso = Integer.parseInt(et3);
            rbStar.setNumStars(numStar);
            rbStar.setRating(numDefault);
            rbStar.setStepSize(tamPasso);
        }else{
            Toast.makeText(this, "EditText não podem estar vázios!", Toast.LENGTH_SHORT).show();
        }

    }


}
