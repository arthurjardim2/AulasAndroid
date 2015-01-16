package com.android.josias.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.josias.layouts.views.MenusActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openFL(View v){
        Intent i = new Intent(this, FrameLayoutActivity.class);
        startActivity(i);
    }

    public void openLL(View v){
        Intent i = new Intent(this, LinearLayoutActivity.class);
        startActivity(i);
    }

    public void openRL(View v){
        Intent i = new Intent(this, RelativeLayoutActivity.class);
        startActivity(i);
    }

    public void openDL(View v){
        Intent i = new Intent(this, DrawerLayoutActivity.class);
        startActivity(i);
    }

    public void openViews(View v){
        Intent i = new Intent(this, ViewsActivity.class);
        startActivity(i);
    }

    public void openMenus(View v){
        Intent i = new Intent(this, MenusActivity.class);
        startActivity(i);
    }

    public void openDialogs(View v){
        Intent i = new Intent(this, DialogsActivity.class);
        startActivity(i);
    }

    public void openListView(View v){
        Intent i = new Intent(this, ListViewActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
