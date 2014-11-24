package com.example.chris.escape201game;
import android.app.Application;

/**
 * Victor
 *
 * by extending Application I can store objects/variables in it
 * which can then be accessed by activities using State mystate = ((State) getApplicationContext());
 * myState.getMusicOn() will call getMusicOn in this class
 *
 * store persistent variables that can be get/set by all activities
 * used for configuring music, sfx, and tips
 */
public class State extends Application {
    private boolean musicOn, sfxOn, tipsOn, singleRun;

    public State(){
        musicOn = true;
        sfxOn = true;
        tipsOn = false;
        singleRun = true;
    }

    public boolean getMusicOn(){
        return musicOn;
    }

    public void setMusicOn(boolean music){
        musicOn = music;
    }

    public boolean getSfxOn(){
        return sfxOn;
    }

    public void setSfxOn(boolean sfx){
        sfxOn = sfx;
    }

    public boolean getTipsOn(){
        return tipsOn;
    }

    public void setTipsOn(boolean tips){
        tipsOn = tips;
    }

    public boolean getSingleRun(){ return singleRun;}

    public void setSingleRun(boolean oneRun){ singleRun = oneRun;}
}
