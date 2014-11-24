package com.example.chris.escape201game;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class SettingsScreen extends LevelandSettingsScreen {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
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
        boolean checked = ((CheckBox) view).isChecked();

        //check which checkbox was clicked
        //for setting boolean var, change var to private and use set/get methods 
        switch(view.getId()){
            case R.id.musicChbxID:
                if (checked) {
                    onResume();
                    setMusicOn(true);
                }
                else {
                    onPause();
                    setMusicOn(false);
                }
                break;
            case R.id.sfxChbxID:
                if (checked)
                    setSfxOn(true);
                else
                    setSfxOn(false);
                break;
            case R.id.tipsChbxID:
                if (checked)
                    setTipsOn(true);
                else
                    setTipsOn(false);
                break;
        }
    }
}
