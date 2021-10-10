package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView showCounter;
    private Button countButton;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCounter = (TextView) findViewById(R.id.showCounter);
        countButton = (Button) findViewById(R.id.button3);
        resetButton = (Button) findViewById(R.id.button);
    }

    public void showToastMessage(View view) {
        Toast toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        counter++;
        if (showCounter != null) {
            showCounter.setText( Integer.toString(counter) );
        }

        resetButton.setBackgroundColor(Color.BLUE);
        resetButton.setClickable(true);

        if (counter % 2 == 0) {
            view.setBackgroundColor(Color.MAGENTA);
        } else {
            view.setBackgroundColor(Color.GREEN);
        }
    }

    public void resetToZero(View view) {
        counter = 0;
        if (showCounter != null) {
            showCounter.setText( Integer.toString(counter) );
        }

        view.setClickable(false);
        view.setBackgroundColor(Color.GRAY);
        countButton.setBackgroundColor(Color.BLUE);
    }
}