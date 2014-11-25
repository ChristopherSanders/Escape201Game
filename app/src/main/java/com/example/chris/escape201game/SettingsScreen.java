package com.example.chris.escape201game;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

//http://soundbible.com/2067-Blop.html

public class SettingsScreen extends Escape201Game {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        //victor
        //use State to change the values of the checkboxes to match what is in the State class
        musicChbx = (CheckBox) findViewById(R.id.musicChbxID);
        sfxChbx = (CheckBox) findViewById(R.id.sfxChbxID);
        tipsChbx = (CheckBox) findViewById(R.id.tipsChbxID);

        State myState = ((State) getApplicationContext());
        musicChbx.setChecked(myState.getMusicOn());
        sfxChbx.setChecked(myState.getSfxOn());
        tipsChbx.setChecked(myState.getTipsOn());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_screen, menu);
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

    public void onCheckboxClicked(View view) {
        //Victor
        //after validating checkbox, use set methods in State.
        boolean checked = ((CheckBox) view).isChecked();
        State myState = ((State) getApplicationContext());

        //check which checkbox was clicked
        switch(view.getId()){
            case R.id.musicChbxID:
                if (checked) {
                    myState.setMusicOn(true);
                }
                else {
                    myState.setMusicOn(false);
                }
                break;
            case R.id.sfxChbxID:
                if (checked)
                    myState.setSfxOn(true);
                else
                    myState.setSfxOn(false);
                break;
            case R.id.tipsChbxID:
                if (checked)
                    myState.setTipsOn(true);
                else
                    myState.setTipsOn(false);
                break;
        }
        keepState();
    }
}
