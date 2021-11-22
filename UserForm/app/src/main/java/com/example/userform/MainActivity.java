package com.example.userform.;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.userform.R;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText editTextName, editTextStudentID, editTextDateOfBirth, editTextPhoneNumber, editTextEmail;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextDateOfBirth = findViewById(R.id.editTextDateOfBirth);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);

        result = findViewById(R.id.result);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasInputTextEmpty(editTextName, editTextStudentID, editTextDateOfBirth,
                        editTextPhoneNumber, editTextEmail)) {
                    result.setText("Invalid input");
                } else {
                    result.setText("Submit success");
                }
            }
        });
    }

    private boolean hasInputTextEmpty(EditText... editText) {
        for (EditText temp : editText) {
            if (temp.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}