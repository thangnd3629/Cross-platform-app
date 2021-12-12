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

public class UnitConvertFragment extends Fragment {
    List<String> base = Arrays.asList("Kilometre (km)", "Met (m)", "Millimetre (mm)");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert_unit, container, false);

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
                String fromBaseValue = (String) fromBase.getSelectedItem();
                String toBaseValue = (String) toBase.getSelectedItem();
                String number = inputTxtView.getText().toString();
                Log.v("ConvertApp", String.format(" Convert number %s from base %s to base %s", number, fromBaseValue, toBaseValue));
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

    private String convertFromBaseToBase(String number, String fromBase, String toBase) {
        return Double.toString(Double.parseDouble(number) * Math.pow(10, 3 * (base.indexOf(toBase) - base.indexOf(fromBase))));
    }
}
