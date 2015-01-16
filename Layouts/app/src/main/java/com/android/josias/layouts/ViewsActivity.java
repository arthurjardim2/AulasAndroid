package com.android.josias.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.josias.layouts.views.CheckBoxActivity;
import com.android.josias.layouts.views.DateTimePickerActivity;
import com.android.josias.layouts.views.ImageViewActivity;
import com.android.josias.layouts.views.RadioButtonActivity;
import com.android.josias.layouts.views.RatingBarActivity;
import com.android.josias.layouts.views.SpinnerActivity;
import com.android.josias.layouts.views.TextViewEditTextButtonActivity;
import com.android.josias.layouts.views.WebViewActivity;


public class ViewsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
    }

    public void openTvButton (View v){
        Intent i = new Intent(this, TextViewEditTextButtonActivity.class);
        startActivity(i);
    }

    public void openCheckBox (View v){
        Intent i = new Intent(this, CheckBoxActivity.class);
        startActivity(i);
    }

    public void openRadioButton (View v){
        Intent i = new Intent(this, RadioButtonActivity.class);
        startActivity(i);
    }

    public void openIV (View v){
        Intent i = new Intent(this, ImageViewActivity.class);
        startActivity(i);
    }

    public void openSpinner (View v){
        Intent i = new Intent(this, SpinnerActivity.class);
        startActivity(i);
    }

    public void openRB (View v){
        Intent i = new Intent(this, RatingBarActivity.class);
        startActivity(i);
    }

    public void openWebView (View v){
        Intent i = new Intent(this, WebViewActivity.class);
        startActivity(i);
    }

    public void openDTPicker (View v){
        Intent i = new Intent(this, DateTimePickerActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_views, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
