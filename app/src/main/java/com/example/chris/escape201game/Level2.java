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
    private boolean l2_clockHand_selected, l2_screenUp, l2_leftSwitchUp, l2_rightSwitchUp, l2_clockBroken;
    Button l2_keypadBtn, l2_projBtn, l2_trashCanBtn, l2_clockBtn, l2_selectClockBtn, l2_whiteBoardBtn, l2_clockHandBtn, l2_lightSwitchBtn,
            l2_lightSwitchLeftBtn, l2_lightSwitchRightBtn, l2_backBtn, l2_dropScreenBtn, l2_doorViewBtn, l2_submitBtn;
    ImageButton  l2_inventory_clockHandBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        View mainLayout = findViewById(R.id.level2_layout);

        //Ensure when this is created that screen is up - Chris
        mainLayout.setBackgroundResource(R.drawable.screenup);
        l2_screenUp = true;
        // Set switches are off
        l2_leftSwitchUp = false;
        l2_rightSwitchUp = false;
        // Set clock as broken
        l2_clockBroken = true;

        //buttons, codetext
        l2_codeText = (EditText) findViewById(R.id.l2_codeTextId);
        l2_keypadBtn = (Button) findViewById(R.id.l2_keypadBtnId);
        l2_projBtn = (Button) findViewById(R.id.l2_projBtnId);
        l2_trashCanBtn = (Button) findViewById(R.id.l2_trashCanBtnId);
        l2_clockBtn = (Button) findViewById(R.id.l2_clockBtnId);
        l2_selectClockBtn = (Button) findViewById(R.id.l2_selectClockBtnId);
        l2_whiteBoardBtn = (Button) findViewById(R.id.l2_whiteBoardBtnId);
        l2_clockHandBtn = (Button) findViewById(R.id.l2_clockHandBtnId);
        l2_lightSwitchBtn = (Button) findViewById(R.id.l2_lightSwitchBtnId);
        l2_lightSwitchLeftBtn = (Button) findViewById(R.id.l2_lightSwitchLeftBtnId);
        l2_lightSwitchRightBtn = (Button) findViewById(R.id.l2_lightSwitchRightBtnId);
        l2_inventory_clockHandBtn = (ImageButton) findViewById(R.id.l2_inventory_clockHandBtnId);
        l2_backBtn = (Button) findViewById(R.id.l2_backBtnId);
        l2_dropScreenBtn = (Button) findViewById(R.id.l2_dropScreenBtnId);
        l2_doorViewBtn = (Button) findViewById(R.id.l2_doorViewBtnId);
        l2_submitBtn = (Button) findViewById(R.id.l2_submitBtnId);
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

    //change whether drop screen is up or down - Chris
    public void changeDropScreen(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        if (!l2_screenUp) {//drop screen down
            mainLayout.setBackgroundResource(R.drawable.screenup);
        }
        else if (l2_screenUp) {//drop screen up
            mainLayout.setBackgroundResource(R.drawable.screendown);
        }
        l2_dropScreenBtn.setVisibility(View.INVISIBLE);
        l2_doorViewBtn.setVisibility(View.INVISIBLE);
    }

    //Zoom to keypad and enable buttons - Chris/Dean
    public void goToKeypad_2(View v){
        //change the background
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        mainLayout.setBackgroundResource(R.drawable.room201keypad);
        l2_codeText.setVisibility(View.VISIBLE);
        l2_submitBtn.setVisibility(View.VISIBLE);
        l2_codeText.setBackgroundColor(Color.argb(79, 99, 00, 04));//Set text box to red and semi-transparent - Chris
    }

    //Zoom to the light switch - Chris
    public void goToLightSwitch_2(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        if ((!l2_rightSwitchUp) & (!l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch00);
        }
        else if ((!l2_rightSwitchUp) & (l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch01);
        }
        else if ((l2_rightSwitchUp) & (!l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch10);
        }
       else if ((l2_rightSwitchUp) & (l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch11);
        }
        l2_lightSwitchLeftBtn.setVisibility(View.INVISIBLE);
        l2_lightSwitchRightBtn.setVisibility(View.INVISIBLE);
    }

    //Zoom to clock view - Chris
    public void goToClock_2(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        //if broken show no hands if fixed show with hands
        if (l2_clockBroken) {
            mainLayout.setBackgroundResource(R.drawable.clocknohands);
        }
        if (!l2_clockBroken){
            mainLayout.setBackgroundResource(R.drawable.clockwhands);
        }
        l2_clockHandBtn.setVisibility(View.INVISIBLE);
    }

    //Go to main door view - Chris
    public void goToDoor_2(View v){
        //change the background
        setButtonsGone();
        View mainLayout = findViewById(R.id.level1_layout);
        if (l2_clockBroken) {
            mainLayout.setBackgroundResource(R.drawable.doorviewclocknohands);
        }
        if (!l2_clockBroken){
            mainLayout.setBackgroundResource(R.drawable.doorviewclockfixed);
        }
        l2_clockBtn.setVisibility(View.INVISIBLE);
        l2_trashCanBtn.setVisibility(View.INVISIBLE);
        l2_keypadBtn.setVisibility(View.INVISIBLE);
        l2_whiteBoardBtn.setVisibility(View.INVISIBLE);
        l2_lightSwitchBtn.setVisibility(View.INVISIBLE);
    }

    //Go to whiteboard view - Chris
    public void goToWhiteBoard_2(View v){
    //change the background
        setButtonsGone();
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.keypadondoor);
        l2_codeText.setVisibility(View.VISIBLE);
//        submitBtn.setVisibility(View.VISIBLE);
//        codeText.setBackgroundColor(Color.argb(79, 99, 00, 04));//red and semi-transparent
//
//        keypadBtn.setVisibility(View.GONE);
//        trashBtn.setVisibility(View.GONE);
//        lightSwitchBtn.setVisibility(View.GONE);
}

//    public void gotoLightSwitch(View v){
//
//    }

// end of deans code



    public void goToTrash_2(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.trashcanwithdots);

//        keypadBtn.setVisibility(View.GONE);
//        trashBtn.setVisibility(View.GONE);
//        lightSwitchBtn.setVisibility(View.GONE);
//
//        Toast toast = Toast.makeText(getApplicationContext(),"You see the numbers 476 in the trash!",Toast.LENGTH_LONG);
//        toast.show();
//
//        backBtn.setVisibility(View.VISIBLE);
    }



    public void gotoMainView(View v){
        View mainLayout = findViewById(R.id.level1_layout);
        mainLayout.setBackgroundResource(R.drawable.doorclosed);

//        keypadBtn.setVisibility(View.VISIBLE);
//        trashBtn.setVisibility(View.VISIBLE);
//        lightSwitchBtn.setVisibility(View.VISIBLE);
//        backBtn.setVisibility(View.GONE);
    }

    public void saveToCode(View v) {
        //change the background
        View mainLayout = findViewById(R.id.level1_layout);
        String str = l2_codeText.getText().toString();
        //if good code door open
        if (str.equals("6378")){
            mainLayout.setBackgroundResource(R.drawable.doorviewdooropen);
            Toast toast = Toast.makeText(getApplicationContext(),"You Win!!",Toast.LENGTH_LONG);
            toast.show();
        }
        //if bad code door closed
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"Passcode Incorrect!",Toast.LENGTH_SHORT);
            toast.show();

        }
        l2_codeText.setVisibility(View.GONE);
//        submitBtn.setVisibility(View.GONE);
//
//        keypadBtn.setVisibility(View.VISIBLE);
//        trashBtn.setVisibility(View.VISIBLE);
//        lightSwitchBtn.setVisibility(View.VISIBLE);
    }

    //set all buttons to gone at change of background - Chris
    @Override
    public void setButtonsGone(){
        l2_codeText.setVisibility(View.GONE);
        l2_keypadBtn.setVisibility(View.GONE);
        l2_projBtn.setVisibility(View.GONE);
        l2_doorBtn.setVisibility(View.GONE);
        l2_trashCanBtn.setVisibility(View.GONE);
        l2_clockBtn.setVisibility(View.GONE);
        l2_selectClockBtn.setVisibility(View.GONE);
        l2_whiteBoardBtn.setVisibility(View.GONE);
        l2_clockHandBtn.setVisibility(View.GONE);
        l2_lightSwitchBtn.setVisibility(View.GONE);
        l2_inventory_clockHandBtn.setVisibility(View.GONE);
        l2_backBtn.setVisibility(View.INVISIBLE);
        l2_dropScreenBtn.setVisibility(View.GONE);
        l2_doorViewBtn.setVisibility(View.GONE);
    }


}
