package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView showCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCounter = (TextView) findViewById(R.id.showCounter);
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
    }
}