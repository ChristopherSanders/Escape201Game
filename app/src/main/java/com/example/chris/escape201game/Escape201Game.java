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
    public int currentSong;
    Button settingsBtn, levelsBtn, playBtn, level1Btn, level2Btn, level3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escape201_game);

        settingsBtn = (Button) findViewById(R.id.settingsBtnID);
        levelsBtn = (Button) findViewById(R.id.levelsBtnID);
        playBtn = (Button) findViewById(R.id.playBtnID);
        level1Btn = (Button) findViewById(R.id.level1BtnID);
        level2Btn = (Button) findViewById(R.id.level2BtnID);
        level3Btn = (Button) findViewById(R.id.level2BtnID);
        mPlayer = MediaPlayer.create(this, R.raw.song1);
        currentSong = R.raw.song1;

        getActionBar().hide();
// hi
        mPlayer.start();
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
    }
}
