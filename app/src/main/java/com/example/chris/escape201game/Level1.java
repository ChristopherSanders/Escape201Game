package com.example.chris.escape201game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Level1 extends Escape201Game {
    private EditText codeText;
    private boolean doorClosed;
    Button keypadBtn, submitBtn, backBtn;
    ImageButton  trashBtn;
    private String l1_currentScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        View mainLayout = findViewById(R.id.level1_layout);

        //Set current screen
        GameState myState = ((GameState) getApplicationContext());
        mainLayout.setBackgroundResource(R.drawable.doorclosed);
        l1_currentScreen = "main"; //will be used if level difficulty increases
        doorClosed = true;

        codeText = (EditText) findViewById(R.id.editText);
        keypadBtn = (Button) findViewById(R.id.keypadBtnID);
        submitBtn = (Button) findViewById(R.id.submitBtnID);
        trashBtn = (ImageButton) findViewById(R.id.trashBtnID);
        backBtn = (Button) findViewById(R.id.backBtnID);
        setMPlayerSong(1);
        keepState();
        playSfx(2);
        if (myState.getTipsOn()){
            enableTipsMode();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.level1, menu);
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

    public void goToKeypad(View v){
        //change the background
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.keypadondoor);
        setButtonsGone();
        codeText.setVisibility(View.VISIBLE);
        submitBtn.setVisibility(View.VISIBLE);
        codeText.setBackgroundColor(Color.argb(79, 99, 00, 04));//red and semi-transparent

        l1_currentScreen = "keypad";
    }

    public void goToTrash(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.trashcanwithdots);
        setButtonsGone();
        Toast toast = Toast.makeText(getApplicationContext(),"You see the numbers 476 in the trash!",Toast.LENGTH_LONG);
        playSfx(0);
        toast.show();

        l1_currentScreen = "trash";
    }

    public void goToPreviousView(View v){
        setButtonsGone();
        if ((l1_currentScreen.equals("main"))) {
            goToMainView(v);
        }
        if ((l1_currentScreen.equals("keypad")) || (l1_currentScreen.equals("trash")) ) {
            goToMainView(v);//this will be changed! - Chris
        }
    }

    public void saveToCode(View v) {
        //change the background
        String str = codeText.getText().toString();
        setButtonsGone();
        //if good code door open
        if (str.equals("476")){
            playSfx(3);
            keepState();
            doorClosed = false;
            goToMainView(v);
            Toast toast = Toast.makeText(getApplicationContext(),"You Win!!",Toast.LENGTH_LONG);
            toast.show();

        }
        //if bad code door closed
        else {
            doorClosed = true;
            Toast toast = Toast.makeText(getApplicationContext(),"Passcode Incorrect!",Toast.LENGTH_SHORT);
            toast.show();
            codeText.setText("");
            goToKeypad(v);
        }
    }

    //Go to the main view
    public void goToMainView(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level1_layout);
        if (doorClosed) {
            mainLayout.setBackgroundResource(R.drawable.doorclosed);
            trashBtn.setVisibility(View.VISIBLE);
            keypadBtn.setVisibility(View.VISIBLE);
        }
        if (!doorClosed){
            mainLayout.setBackgroundResource(R.drawable.dooropen);
        }
        l1_currentScreen = "main";
    }

    //set all buttons to gone at change of background - Chris
    @Override
    public void setButtonsGone(){
        codeText.setVisibility(View.GONE);
        keypadBtn.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);
        trashBtn.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void enableTipsMode(){
        keypadBtn.setBackgroundColor(Color.argb(75, 00, 00, 00));
        trashBtn.setBackgroundColor(Color.argb(75, 00, 00, 00));
        backBtn.setVisibility(View.VISIBLE);
    }


}
