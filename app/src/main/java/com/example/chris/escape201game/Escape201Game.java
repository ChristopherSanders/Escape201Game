package com.example.chris.escape201game;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.util.Log;


public class Escape201Game extends Activity {
    //Victor, Dean, Chris

    private MediaPlayer mPlayer;
    private MediaPlayer sfxPlayer;
    public int currentSong;
    Button settingsBtn, levelsBtn, playBtn, level1Btn, level2Btn, level3Btn;
    CheckBox musicChbx, sfxChbx, tipsChbx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape201_game);
        GameState myState = ((GameState) getApplicationContext());



        //buttons
        settingsBtn = (Button) findViewById(R.id.settingsBtnID);
        levelsBtn = (Button) findViewById(R.id.levelsBtnID);
        playBtn = (Button) findViewById(R.id.playBtnID);
        level1Btn = (Button) findViewById(R.id.level1BtnID);
        level2Btn = (Button) findViewById(R.id.level2BtnID);
        level3Btn = (Button) findViewById(R.id.level2BtnID);
        musicChbx = (CheckBox) findViewById(R.id.musicChbxID);
        sfxChbx = (CheckBox) findViewById(R.id.sfxChbxID);
        tipsChbx = (CheckBox) findViewById(R.id.tipsChbxID);

        //victor
        mPlayer = MediaPlayer.create(this, R.raw.song_screens);
        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_default);
        currentSong = R.raw.song_screens;
        if (myState.getSingleRun()){
            Log.d("Escape201Game", "singleRun is true");
        }
        if (!myState.getSingleRun()){
            Log.d("Escape201Game", "singleRun is false");
        }
        if (myState.getSingleRun()) {
            Log.d("Escape201Game", "entering if statement (should only happen once)");
            mPlayer.start();
            myState.setSingleRun(false);
            Log.d("Escape201Game", "set myState.singleRun to false");
        } else {
            Log.d("Escape201Game", "common if statement");
            keepState();
        }
        getActionBar().hide();

    }

    public void keepState(){
        //victor
        //keepState() is an attempt at having one function control the music,sfx, and tip states
        //each activity calls keepState in its create after calling super.onCreate

        //get from appplicationcontext
        GameState myState = ((GameState) getApplicationContext());

        if (myState.getMusicOn()){
            Log.d("Escape201Game", "musicOn is true, resuming music");
            mPlayer.start();
        } else {
            Log.d("Escape201Game", "musicOn is FALSE, pausing music");
            if (mPlayer.isPlaying()) {
                mPlayer.pause();
            }
        }
        //add sfx and tips later
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPlayer == null) {
            mPlayer = MediaPlayer.create(this, currentSong);
        }

        mPlayer.start();
        keepState();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }

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
        playSfx(0);
    }

    public void setMPlayerSong(int song){
        //victor
        if (mPlayer.isPlaying()){
            mPlayer.stop();
        }
        mPlayer.reset();
        if (song == 0){
            mPlayer = MediaPlayer.create(this, R.raw.song_screens);
            currentSong = R.raw.song_screens;
        } else if (song == 1){
            mPlayer = MediaPlayer.create(this, R.raw.song_level1);
            currentSong = R.raw.song_level1;
        } else if (song == 2){
            mPlayer = MediaPlayer.create(this, R.raw.song2);
            currentSong = R.raw.song_level2;
        } else {
            mPlayer = MediaPlayer.create(this, R.raw.song4);
            currentSong = R.raw.song4;
        }
    }
    
    public void playSfx(int soundEffect){
        //victor
        //0 .. default (popping sound)
        //if no special sfx is define, play 0
        //1 .. lightswitch
        //2 .. doorclosing
        //3 .. unlock
        //4 .. beep (type 1)
        GameState myState = ((GameState) getApplicationContext());
        sfxPlayer.reset();
        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_default);
        if (myState.getSfxOn()) {
            if (soundEffect != 0) {
                //play a specific sound, see above comment for description
                if (soundEffect == 1) {
                    if (!sfxPlayer.isPlaying()){
                        sfxPlayer.reset();
                        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_lightswitch);
                    }
                } else if (soundEffect == 2){
                    if (!sfxPlayer.isPlaying()){
                        sfxPlayer.reset();
                        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_doorclosing);
                    }
                } else if (soundEffect == 3){
                    if (!sfxPlayer.isPlaying()){
                        sfxPlayer.reset();
                        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_doorunlock);
                    }
                } else if (soundEffect == 4){
                    if (!sfxPlayer.isPlaying()){
                        sfxPlayer.reset();
                        sfxPlayer = MediaPlayer.create(this, R.raw.sfx_beep1);
                    }
                }
            }
            sfxPlayer.start();
        }
    }

    public void setButtonsGone(){
        //for each level override with the buttons that correspond
    }

    //get & sets for music,sfx,tips
    //victor
//    public boolean getMusicOn(){
//        return musicOn;
//    }
//
//    public void setMusicOn(boolean music){
//        musicOn = music;
//        if (musicOn) onResume();
//        else onPause();
//    }
//
//    public boolean getSfxOn(){
//        return sfxOn;
//    }
//
//    public void setSfxOn(boolean sfx){
//        sfxOn = sfx;
//    }
//
//    public boolean getTipsOn(){
//        return tipsOn;
//    }
//
//    public void setTipsOn(boolean tips){
//        tipsOn = tips;
//    }

}
