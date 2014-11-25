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


public class Level2 extends Escape201Game {
    private EditText l2_codeText;
    private boolean l2_lightSwitch1, l2_lightSwitch2, l2_projScreenDown, l2_clockHand
    Button l2_keypadBtn, l2_projBtn, l2_doorBtn, l2_trashCanBtn, l2_clockBtn, , l2_selectClockBtn, l2_whiteBoardBtn, l2_clockHand, l2_lightSwitchBtn, 
    ImageButton  l2_inventory_clockHand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        
        //buttons, codetext
        l2_codeText = (EditText) findViewById(R.id.l2_codeTextId);
        l2_keypadBtn = (Button) findViewById(R.id.l2_keypadBtnId);
        l2_projBtn = (Button) findViewById(R.id.l2_projBtnId);
        l2_doorBtn = (Button) findViewById(R.id.l2_doorBtnId);
        l2_trashCanBtn = (Button) findViewById(R.id.l2_trashCanBtnId);
        l2_clockBtn = (Button) findViewById(R.id.l2_clockBtnId);
        l2_selectClockBtn = (Button) findViewById(R.id.l2_selectClockBtnId);
        l2_whiteBoardBtn = (Button) findViewById(R.id.l2_whiteBoardBtnId);
        l2_clockHandBtn = (Button) findViewById(R.id.l2_clockHandId);
        l2_lightSwitchBtn = (Button) findViewById(R.id.l2_lightSwitchBtnId);
        l2_inventory_clockHand = (Button) findViewById(R.id.l2_inventory_clockHand);
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

    public void gotoKeypad(View v){
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

//    public void gotoLightSwitch(View v){
//
//    }

    public void gotoTrash(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.trashcanwithdots);

        keypadBtn.setVisibility(View.GONE);
        trashBtn.setVisibility(View.GONE);
        lightSwitchBtn.setVisibility(View.GONE);

        Toast toast = Toast.makeText(getApplicationContext(),"You see the numbers 476 in the trash!",Toast.LENGTH_LONG);
        toast.show();

        backBtn.setVisibility(View.VISIBLE);
    }

    public void gotoMainView(View v){
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
            mainLayout.setBackgroundResource(R.drawable.doorclosed);
            Toast toast = Toast.makeText(getApplicationContext(),"Passcode Incorrect!",Toast.LENGTH_SHORT);
            toast.show();

        }
        codeText.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);

        keypadBtn.setVisibility(View.VISIBLE);
        trashBtn.setVisibility(View.VISIBLE);
        lightSwitchBtn.setVisibility(View.VISIBLE);
    }


}
