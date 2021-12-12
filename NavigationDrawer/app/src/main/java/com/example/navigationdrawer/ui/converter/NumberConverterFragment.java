package com.example.navigationdrawer.ui.converter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.R;

import java.util.Arrays;
import java.util.List;

public class NumberConverterFragment extends Fragment {

    List<Integer> base = Arrays.asList(2, 8, 10, 16);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_converter, container, false);

        Spinner fromBase = view.findViewById(R.id.fromBase);
        Spinner toBase = view.findViewById(R.id.toBase);
        ArrayAdapter ad = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, base);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromBase.setAdapter(ad);
        toBase.setAdapter(ad);

        TextView inputTxtView = view.findViewById(R.id.txtInput);
        TextView resultTxtView = view.findViewById(R.id.resultTxtView);

        Button convertBtn = view.findViewById(R.id.convertBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("ConvertApp", " Convert btn is clicked");
                int fromBaseValue = (int) fromBase.getSelectedItem();
                int toBaseValue = (int) toBase.getSelectedItem();
                String number = inputTxtView.getText().toString();
                Log.v("ConvertApp", String.format(" Convert number %s from base %d to base %d", number, fromBaseValue, toBaseValue));
                try {
                    String result = convertFromBaseToBase(number, fromBaseValue, toBaseValue);
                    Log.v("ConvertApp", String.format(" Result %s", result));
                    resultTxtView.setText(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button resetBtn = view.findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("ConvertApp", " Reset btn is clicked");
                inputTxtView.setText("");
            }
        });

        return view;
    }

    private String convertFromBaseToBase(String number, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(number, fromBase), toBase);
    }
}
