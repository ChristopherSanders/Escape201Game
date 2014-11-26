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
    Button keypadBtn, submitBtn, backBtn;
    ImageButton  trashBtn, lightSwitchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        codeText = (EditText) findViewById(R.id.editText);
        keypadBtn = (Button) findViewById(R.id.keypadBtnID);
        submitBtn = (Button) findViewById(R.id.submitBtnID);
        trashBtn = (ImageButton) findViewById(R.id.trashBtnID);
        backBtn = (Button) findViewById(R.id.backBtnID);
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
        codeText.setVisibility(View.VISIBLE);
        submitBtn.setVisibility(View.VISIBLE);
        codeText.setBackgroundColor(Color.argb(79, 99, 00, 04));//red and semi-transparent

        keypadBtn.setVisibility(View.GONE);
        trashBtn.setVisibility(View.GONE);
        lightSwitchBtn.setVisibility(View.GONE);
    }

    public void goToTrash(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.trashcanwithdots);

        keypadBtn.setVisibility(View.GONE);
        trashBtn.setVisibility(View.GONE);
        lightSwitchBtn.setVisibility(View.GONE);

        Toast toast = Toast.makeText(getApplicationContext(),"You see the numbers 476 in the trash!",Toast.LENGTH_LONG);
        toast.show();

        backBtn.setVisibility(View.VISIBLE);
    }

    public void goToPreviousView(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.doorclosed);

        keypadBtn.setVisibility(View.VISIBLE);
        trashBtn.setVisibility(View.VISIBLE);
        lightSwitchBtn.setVisibility(View.VISIBLE);
        backBtn.setVisibility(View.GONE);
    }

    public void saveToCode(View v) {
        //change the background
        View mainLayout = findViewById(R.id.level1_layout);
        String str = codeText.getText().toString();
        //if good code door open
        if (str.equals("476")){
            mainLayout.setBackgroundResource(R.drawable.dooropen);
            Toast toast = Toast.makeText(getApplicationContext(),"You Win!!",Toast.LENGTH_LONG);
            toast.show();
        }
        //if bad code door closed
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"Passcode Incorrect!",Toast.LENGTH_SHORT);
            toast.show();

        }
        codeText.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);

        keypadBtn.setVisibility(View.VISIBLE);
        trashBtn.setVisibility(View.VISIBLE);
        lightSwitchBtn.setVisibility(View.VISIBLE);
    }

    //set all buttons to gone at change of background - Chris
    @Override
    public void setButtonsGone(){
        codeText.setVisibility(View.GONE);
        keypadBtn.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);
        trashBtn.setVisibility(View.GONE);
        lightSwitchBtn.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
    }


}
