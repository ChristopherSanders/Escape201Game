package com.example.chris.escape201game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LevelandSettingsScreen extends Escape201Game {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leveland_settings_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.leveland_settings_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoLevelSelectActivity(View v){
        Intent intent = new Intent(this, LevelSelectScreen.class);
        startActivity(intent);
        playSfx(0);
    }

    public void gotoSettingsActivity(View v){
        Intent intent = new Intent(this, SettingsScreen.class);
        startActivity(intent);
        playSfx(0);
    }
}
