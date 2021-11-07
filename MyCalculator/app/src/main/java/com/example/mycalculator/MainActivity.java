package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display.getText().toString().equals("Enter values") ){
                    display.setText("");
                }
            }
        });
    }

    public void update(String addStr){
        String oldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String left = oldStr.substring(0, cursor);
        String right = oldStr.substring(cursor);
        display.setText(left+addStr+right);
    }

    public void backspaceBTN(View view){

    }
    public void zeroBTN(View view){
        update("0");
    }
    public void oneBTN(View view){
        update("1");
    }
    public void twoBTN(View view){
        update("2");
    }
    public void threeBTN(View view){
        update("3");
    }
    public void fourBTN(View view){
        update("4");
    }
    public void fiveBTN(View view){
        update("5");
    }
    public void sixBTN(View view){
        update("6");
    }
    public void sevenBTN(View view){
        update("7");
    }
    public void eightBTN(View view){
        update("8");
    }
    public void nineBTN(View view){
        update("9");
    }
    public void plusBTN(View view){
        update("+");
    }
    public void minusBTN(View view){
        update("-");
    }
    public void divideBTN(View view){
        update("/");
    }
    public void moduloBTN(View view){
        update("%");
    }
    public void multiplyBTN(View view){
        update("*");
    }






}