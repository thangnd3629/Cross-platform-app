package com.example.navigationdrawer.ui.converter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.compactnavigationdrawer.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Base {
    BINARY,
    OCTA,
    HEXA,
    DECIMAL

}

public class NumberConverterFragment extends Fragment {


    EditText input;
    Spinner src, target;
    Button convert_action;
    TextView result;


    List<Integer> base = Arrays.asList(2, 8, 10, 16);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_converter, container, false);


        input = view.findViewById(R.id.input);
        result = view.findViewById(R.id.result);
        result.setText("");
        src = view.findViewById(R.id.source_base);

        target = view.findViewById(R.id.target_base);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, populateOptions());


        src.setAdapter(adapter);
        target.setAdapter(adapter);


        convert_action = view.findViewById(R.id.convert_action);
        convert_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String source_base = (String) src.getSelectedItem();
                String des_base = (String) target.getSelectedItem();
                System.out.println("OKla");

                try {
                    System.out.println(input.getText().toString());
                    String convertedInput = Integer.toString(
                            Integer.parseInt(input.getText().toString(), encodeBase(source_base)), encodeBase(des_base));
                    result.setText(convertedInput);
                } catch (NumberFormatException e) {
                    System.out.println("in error handler");
                    result.setText("Wrong number format");
                }


            }
        });


        return view;
    }


    public List<String> populateOptions() {
        List<String> options = new ArrayList<>();
        options.add(Base.BINARY.name());
        options.add(Base.DECIMAL.name());
        options.add(Base.HEXA.name());
        options.add(Base.OCTA.name());
        return options;
    }

    public int encodeBase(String base) {
        int encodedBase = 0;

        if (base == Base.BINARY.name()) {
            encodedBase = 2;
        } else if (base == Base.DECIMAL.name()) {
            encodedBase = 10;
        } else if (base == Base.HEXA.name()) {
            encodedBase = 16;

        } else if (base == Base.OCTA.name()) {
            encodedBase = 8;
        } else {

        }


        return encodedBase;
    }

    public void convert(String source, String target, String input) {

    }
}
