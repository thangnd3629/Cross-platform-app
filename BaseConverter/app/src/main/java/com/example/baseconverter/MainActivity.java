package com.example.baseconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

enum Base{
    BINARY,
    HEXA,
    DECIMAL

}

public class MainActivity extends AppCompatActivity {

    EditText input;
    Spinner src , target;
    Button convert_action;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        result.setText("");
        src= findViewById(R.id.source_base);

        target= findViewById(R.id.target_base);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, populateOptions()
        );

        src.setAdapter(adapter);
        target.setAdapter(adapter);



        convert_action = findViewById(R.id.convert_action);
        convert_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source_base = (String) src.getSelectedItem();
                String des_base = (String) target.getSelectedItem();

                try {
                    System.out.println(input.getText().toString());
                    String convertedInput =  Integer.toString(
                            Integer.parseInt(input.getText().toString(), encodeBase(source_base)), encodeBase(des_base));
                    result.setText(convertedInput);
                }
                catch (NumberFormatException e)
                {
                    result.setText("Wrong number format");
                }


            }
        });


    }


    public List<String> populateOptions()
    {
        List<String > options = new ArrayList<>();
        options.add(Base.BINARY.name());
        options.add(Base.DECIMAL.name());
        options.add(Base.HEXA.name());
        return  options;
    }
    public int encodeBase(String base)
    {
        int encodedBase = 0;

        if(base == Base.BINARY.name())
        {
            encodedBase = 2;
        }
        else if(base == Base.DECIMAL.name())
        {
            encodedBase = 10;
        }
        else if(base == Base.HEXA.name())
        {
            encodedBase = 16;
        }
        else {

        }


        return encodedBase;
    }

    public void convert(String source, String target, String input)
    {

    }
}