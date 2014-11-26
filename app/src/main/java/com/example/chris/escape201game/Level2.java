package com.example.chris.escape201game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Level2 extends Escape201Game {
    private EditText l2_codeText;
    private String l2_currentScreen;
    private boolean l2_clockHand_selected, l2_screenUp, l2_leftSwitchUp, l2_rightSwitchUp, l2_clockBroken, l2_clockHandFound;
    Button l2_keypadBtn, l2_trashCanBtn, l2_clockBtn, l2_whiteBoardBtn, l2_clockHandBtn, l2_lightSwitchBtn,
            l2_lightSwitchLeftBtn, l2_lightSwitchRightBtn, l2_backBtn, l2_dropScreenBtn, l2_doorViewBtn, l2_submitBtn, l2_fixClockBtn;
    private TextView l2_paperText;
//    ImageButton  l2_inventory_clockHandBtn;

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
        l2_clockHand_selected = false;
        l2_clockHandFound = false;

        //set current screen
        l2_currentScreen = "main";

        //set music
        setMPlayerSong(2);

        //door closing
        playSfx(2);

        //buttons, codetext
        l2_codeText = (EditText) findViewById(R.id.l2_codeTextId);
        l2_keypadBtn = (Button) findViewById(R.id.l2_keypadBtnId);
        l2_trashCanBtn = (Button) findViewById(R.id.l2_trashCanBtnId);
        l2_clockBtn = (Button) findViewById(R.id.l2_clockBtnId);
        l2_whiteBoardBtn = (Button) findViewById(R.id.l2_whiteBoardBtnId);
        l2_clockHandBtn = (Button) findViewById(R.id.l2_clockHandBtnId);
        l2_lightSwitchBtn = (Button) findViewById(R.id.l2_lightSwitchBtnId);
        l2_lightSwitchLeftBtn = (Button) findViewById(R.id.l2_lightSwitchLeftBtnId);
        l2_lightSwitchRightBtn = (Button) findViewById(R.id.l2_lightSwitchRightBtnId);
//        l2_inventory_clockHandBtn = (ImageButton) findViewById(R.id.l2_inventory_clockHandBtnId);
        l2_backBtn = (Button) findViewById(R.id.l2_backBtnId);
        l2_dropScreenBtn = (Button) findViewById(R.id.l2_dropScreenBtnId);
        l2_doorViewBtn = (Button) findViewById(R.id.l2_doorViewBtnId);
        l2_submitBtn = (Button) findViewById(R.id.l2_submitBtnId);
        l2_fixClockBtn = (Button) findViewById(R.id.l2_fixClockBtnId);

        l2_paperText = (TextView) findViewById(R.id.paperTextId);
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
        playSfx(4);
        View mainLayout = findViewById(R.id.level2_layout);
        if (!l2_screenUp) {//drop screen down
            mainLayout.setBackgroundResource(R.drawable.screenup);
            l2_screenUp = true;
        }
        else if (l2_screenUp) {//drop screen up
            mainLayout.setBackgroundResource(R.drawable.screendown);
            l2_screenUp = false;
        }
        l2_dropScreenBtn.setVisibility(View.VISIBLE);
        l2_doorViewBtn.setVisibility(View.VISIBLE);
        l2_currentScreen = "main";
    }

    //Zoom to keypad and enable buttons - Chris/Dean
    public void goToKeypad_2(View v){
        //change the background
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        mainLayout.setBackgroundResource(R.drawable.room201keypad);
        playSfx(0);
        l2_codeText.setVisibility(View.VISIBLE);
        l2_submitBtn.setVisibility(View.VISIBLE);
        l2_codeText.setBackgroundColor(Color.argb(79, 99, 00, 04));//Set text box to red and semi-transparent - Chris
        l2_currentScreen = "keypad";
    }

    //Zoom to the light switch - Chris
    public void goToLightSwitch_2(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        //Set layout to reflect switch change
        if ((!l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch00);
        }
        else if ((l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch10);
        }
        else if ((!l2_leftSwitchUp) && (l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch01);
        }
        else if ((l2_rightSwitchUp) && (l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch11);
        }
        l2_lightSwitchLeftBtn.setVisibility(View.VISIBLE);
        l2_lightSwitchRightBtn.setVisibility(View.VISIBLE);
        l2_currentScreen = "lightswitch";
    }

    //Zoom to clock view - Chris/ method call created by Dean
    public void goToClock_2(View v){
        setButtonsGone();
        View mainLayout = findViewById(R.id.level2_layout);
        //if broken show no hands if fixed show with hands
        playSfx(0);
        if (l2_clockBroken) {
            mainLayout.setBackgroundResource(R.drawable.clocknohands);
            l2_fixClockBtn.setVisibility(View.VISIBLE);
        }
        if (!l2_clockBroken){
            mainLayout.setBackgroundResource(R.drawable.clockwhands);
        }
        l2_currentScreen = "clock";
    }

    //Go to main door view - Chris/ method call created by Dean
    public void goToDoor_2(View v){
        //change the background
        View mainLayout = findViewById(R.id.level2_layout);
        if (l2_clockBroken) {
            mainLayout.setBackgroundResource(R.drawable.doorviewclocknohands);
        }
        if (!l2_clockBroken){
            mainLayout.setBackgroundResource(R.drawable.doorviewclockfixed);
        }
        setButtonsGone();
        playSfx(0);
        updatePaperText(v);
        l2_paperText.setVisibility(View.VISIBLE);
        l2_clockBtn.setVisibility(View.VISIBLE);
        l2_trashCanBtn.setVisibility(View.VISIBLE);
        l2_keypadBtn.setVisibility(View.VISIBLE);
        l2_whiteBoardBtn.setVisibility(View.VISIBLE);
        l2_lightSwitchBtn.setVisibility(View.VISIBLE);
        l2_currentScreen = "door";
    }

    //Go to whiteboard view - Chris/ method call created by Dean
    public void goToWhiteBoard_2(View v) {
        //change the background
        setButtonsGone();
        playSfx(0);
        View mainLayout = findViewById(R.id.level2_layout);
        // if clock hand not found enable button and show on board otherwise show it removed - Chris
        if (!l2_clockHandFound) {
            mainLayout.setBackgroundResource(R.drawable.clockpieceonboard);
            l2_clockHandBtn.setVisibility(View.VISIBLE);
        }
        else if (l2_clockHandFound) {
            mainLayout.setBackgroundResource(R.drawable.clockpieceremovedfromboard);
        }
        l2_currentScreen = "whiteboard";
    }

    //Zoom into trash can
    public void goToTrash_2(View v){
        setButtonsGone();
        playSfx(0);
        View mainLayout = findViewById(R.id.level2_layout);
        mainLayout.setBackgroundResource(R.drawable.trashcanl2);
        l2_currentScreen = "trash";
    }

    // Go to main view - Chris
    public void goToMainView(View v) {
        setButtonsGone();

        View mainLayout = findViewById(R.id.level2_layout);
        if (l2_screenUp) {//drop screen down
            mainLayout.setBackgroundResource(R.drawable.screenup);
        }
        else if (!l2_screenUp) {//drop screen up
            mainLayout.setBackgroundResource(R.drawable.screendown);
        }
        l2_dropScreenBtn.setVisibility(View.VISIBLE);
        l2_doorViewBtn.setVisibility(View.VISIBLE);
        l2_currentScreen = "main";
    }

    //Go back to previous screen - Chris
    public void goToPreviousView(View v){
        setButtonsGone();
//        View mainLayout = findViewById(R.id.level2_layout);
        if ( (l2_currentScreen.equals("main")) || (l2_currentScreen.equals("complete")) ){
            //go back to level select
        }
        else if (l2_currentScreen.equals("door")) {
            goToMainView(v);
        }
        else if ( (l2_currentScreen.equals("keypad")) || (l2_currentScreen.equals("lightswitch")) ||
                (l2_currentScreen.equals("whiteboard")) || (l2_currentScreen.equals("trash")) ||
                (l2_currentScreen.equals("clock")) ){
            goToDoor_2(v);
        }
    }

    // Pick up clock piece for later use - Chris
    public void pickUpClockPiece(View v){
        setButtonsGone();
        playSfx(0);
        View mainLayout = findViewById(R.id.level2_layout);
        l2_clockHandFound = true;
        // pick up clock piece, change view, and display message - Chris
        mainLayout.setBackgroundResource(R.drawable.clockpieceremovedfromboard);
        Toast toast = Toast.makeText(getApplicationContext(),"You found a clock piece!",Toast.LENGTH_LONG);
        toast.show();
    }

    // Fix the clock if broken - Chris
    public void fixClock(View v){
        setButtonsGone();
        playSfx(0);
//        View mainLayout = findViewById(R.id.level2_layout);
        //if clock piece found then it fixes it - Chris
        if (l2_clockHandFound) {
            l2_clockBroken = false;
            goToPreviousView(v);
        }
    }

    //fixed to work for the code in level 2 - Chris
    public void saveToCode(View v) {
        //change the background
        View mainLayout = findViewById(R.id.level2_layout);
        String str = l2_codeText.getText().toString();
        //if good code door open
        if (str.equals("6378")){
            playSfx(3);
            setButtonsGone();
            mainLayout.setBackgroundResource(R.drawable.doorviewdooropen);
            l2_currentScreen = "complete";
            Toast toast = Toast.makeText(getApplicationContext(),"You Win!!",Toast.LENGTH_LONG);
            toast.show();
        }
        //if bad code door closed
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"Passcode Incorrect!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    // Change the lights for the left switch
    public void changeLeftSwitch(View v){
        View mainLayout = findViewById(R.id.level2_layout);
        playSfx(1);
        // Change light switch boolean
        if (l2_leftSwitchUp) {
            l2_leftSwitchUp = false;
        }
        else if (!l2_leftSwitchUp){
            l2_leftSwitchUp = true;
        }

        //Set layout to reflect switch change
        if ((!l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch00);

        }
        else if ((l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch10);
        }
        else if ((!l2_leftSwitchUp) && (l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch01);
        }
        else if ((l2_rightSwitchUp) && (l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch11);
        }
        updatePaperText(v);
        l2_currentScreen = "lightswitch";
    }

    //change the lights for the right switch
    public void changeRightSwitch(View v){
        View mainLayout = findViewById(R.id.level2_layout);
        playSfx(1);
        // Change light switch boolean
        if (l2_rightSwitchUp) {
            l2_rightSwitchUp = false;
        }
        else if (!l2_rightSwitchUp){
            l2_rightSwitchUp = true;
        }

        //Set layout to reflect switch change
        if ((!l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch00);
        }
        else if ((l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch10);
        }
        else if ((!l2_leftSwitchUp) && (l2_rightSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch01);
        }
        else if ((l2_rightSwitchUp) && (l2_leftSwitchUp)) {
            mainLayout.setBackgroundResource(R.drawable.lightswitch11);
        }
        updatePaperText(v);
        l2_currentScreen = "lightswitch";
    }

    public void updatePaperText(View v){
        //Set layout to reflect switch change
        if ((!l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            l2_paperText.setText("Chair");
            l2_paperText.setTextColor(Color.argb(99, 99, 00, 00));
        }
        else if ((l2_leftSwitchUp) && (!l2_rightSwitchUp)) {
            l2_paperText.setText("Chair");
            l2_paperText.setTextColor(Color.argb(99, 00, 99, 00));
        }
        else if ((!l2_leftSwitchUp) && (l2_rightSwitchUp)) {
            l2_paperText.setText("Marker");
            l2_paperText.setTextColor(Color.argb(99, 00, 00, 99));
        }
        else if ((l2_rightSwitchUp) && (l2_leftSwitchUp)) {
            l2_paperText.setText("Minute");
            l2_paperText.setTextColor(Color.argb(99, 99, 99, 00));
        }
    }

    //set all buttons to gone at change of background - Chris
    @Override
    public void setButtonsGone(){
        l2_codeText.setVisibility(View.GONE);
        l2_keypadBtn.setVisibility(View.GONE);
        l2_trashCanBtn.setVisibility(View.GONE);
        l2_clockBtn.setVisibility(View.GONE);
        l2_whiteBoardBtn.setVisibility(View.GONE);
        l2_clockHandBtn.setVisibility(View.GONE);
        l2_lightSwitchBtn.setVisibility(View.GONE);
        l2_backBtn.setVisibility(View.VISIBLE);
        l2_dropScreenBtn.setVisibility(View.GONE);
        l2_doorViewBtn.setVisibility(View.GONE);
        l2_submitBtn.setVisibility(View.GONE);
        l2_fixClockBtn.setVisibility(View.GONE);
        l2_lightSwitchLeftBtn.setVisibility(View.GONE);
        l2_lightSwitchRightBtn.setVisibility(View.GONE);
        l2_paperText.setVisibility(View.GONE);

    }


}
