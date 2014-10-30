package com.example.chris.escape201game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LevelSelectScreen extends LevelandSettingsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.level_select_screen, menu);
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

    @Override
    public void gotoActivity(View v){
        Intent intent = new Intent(this, LevelandSettingsScreen.class);;
        if (v == level1Btn){
            currentSong = R.raw.song2;
            intent = new Intent(this, Level1.class);
        }
        else if (v == level2Btn){
            currentSong = R.raw.song3;
            intent = new Intent(this, Level1.class);
        }
        else if (v == level3Btn){
            currentSong = R.raw.song4;
            intent = new Intent(this, Level1.class);
        }
        onResume();
        startActivity(intent);
    }
}
