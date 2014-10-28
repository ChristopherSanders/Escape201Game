package com.example.chris.escape201game;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Escape201Game extends Activity {

    private MediaPlayer mPlayer;
    private int currentSong;
    Button settingsBtn, levelsBtn, playBtn, level1Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape201_game);

        settingsBtn = (Button) findViewById(R.id.settingsBtnID);
        levelsBtn = (Button) findViewById(R.id.levelsBtnID);
        playBtn = (Button) findViewById(R.id.playBtnID);
        level1Btn = (Button) findViewById(R.id.level1BtnID);

//        if (getCallingActivity() == LevelandSettingsScreen) {
//            mPlayer = MediaPlayer.create(this, R.raw.song1);
//            currentSong = R.raw.song1;
//        } else if (number == 2) {
//            mPlayer = MediaPlayer.create(this, R.raw.song2);
//            currentSong = R.raw.song2;
//
//        } else if (number == 3) {
//            mPlayer = MediaPlayer.create(this, R.raw.song3);
//            currentSong = R.raw.song3;
//
//        } else if (number == 4) {
//            mPlayer = MediaPlayer.create(this, R.raw.song4);
//            currentSong = R.raw.song4;
//
//            // Defaults are always a good idea:
//        } else {
            mPlayer = MediaPlayer.create(this, R.raw.song1);
            currentSong = R.raw.song1;

//        }

        mPlayer.start();

//        createListeners();


    }

//    private void startSettingsScreenActivity(int buttonNum) {
//        Intent intent = new Intent(this, SettingsScreen.class);
//        intent.putExtra("BUTTON NUMBER", buttonNum);
//        startActivity(intent);
//    }

//    private void createListeners(){
//        settingsBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startSettingsScreenActivity(1);
//                // TODO Auto-generated method stub
//            }
//        });
//
//        levelsBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//            }
//        });
//
//        playBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//            }
//        });
//
//        level1Btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//            }
//        });
//    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.escape201_game, menu);
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

    public void gotoActivity(View v){
        Intent intent = new Intent(this, LevelandSettingsScreen.class);
        startActivity(intent);
    }
}
