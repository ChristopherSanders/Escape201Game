package com.example.chris.escape201game;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LevelSelectScreen extends LevelandSettingsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//hello
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

    public void gotoLevel1Activity(View v){
        currentSong = R.raw.song2;
        Intent intent = new Intent(this, Level1.class);
        onResume();
        startActivity(intent);
    }

    public void gotoLevel2Activity(View v){
        currentSong = R.raw.song3;
        Intent intent = new Intent(this, Level2.class);
        onResume();
        startActivity(intent);
    }

    public void gotoLevel3Activity(View v){
        currentSong = R.raw.song4;
        Intent intent = new Intent(this, Level2.class);
        onResume();
        startActivity(intent);
    }

}
