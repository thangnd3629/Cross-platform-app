package com.example.navigationdrawer.ui.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.R;

import java.util.Arrays;
import java.util.List;

public class CalculatorFragment extends Fragment {

    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLE = "*";
    private static final String DIVIDE = "/";
    private static final String EQUAL = "=";
    private static final String SPACE = " ";
    private static final String NUM_LOG_TAG = "CalculatorApp";
    private boolean isTypingNum = false;
    private double currentNum = 0;
    private double currentRes = 0;
    private String currentOperator;

    private List<Integer> numBtnID;
    private List<Integer> operatorBtnID;

    private Button clearBtn, clearEntryBtn, perBtn, equalBtn, dotBtn, reverseBtn, delBtn;
    private TextView resultTxt, inputTxt;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        numBtnID = Arrays.asList(R.id.num0Btn, R.id.num1Btn, R.id.num2Btn,
                R.id.num3Btn, R.id.num4Btn, R.id.num5Btn, R.id.num6Btn,
                R.id.num7Btn, R.id.num8Btn, R.id.num9Btn);
        operatorBtnID = Arrays.asList(R.id.plusBtn, R.id.subBtn,
                R.id.mulBtn, R.id.divBtn);

        setOnClickListenerForNumBtn(view);
        setOnClickListenerForOperatorBtn(view);

        clearBtn = (Button) view.findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on clear button");
                setCurrentNum(0);
            }
        });

        clearEntryBtn = (Button) view.findViewById(R.id.clearEntryBtn);
        clearEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on clear entry button");
                setCurrentNum(0);
                setCurrentRes(0);
            }
        });

        perBtn = (Button) view.findViewById(R.id.perBtn);
        perBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on per button");
                double newCurrentNum = currentNum / 100;
                setCurrentNum(newCurrentNum);
            }
        });

        equalBtn = (Button) view.findViewById(R.id.equalBtn);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on equal button");
                if ( !isEmptyTxtList((String) inputTxt.getText(), (String) resultTxt.getText()) ) {
                    Log.v(NUM_LOG_TAG, "set new value");
                    double res = calculate(currentRes, currentNum, currentOperator);
                    setCurrentNum(res);
                }
            }
        });

        dotBtn = (Button) view.findViewById(R.id.dotBtn);
        // TODO

        reverseBtn = (Button) view.findViewById(R.id.reverseSignBtn);
        reverseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on reverse button");
                if ( !((String) inputTxt.getText()).isEmpty() ) {
                    Log.v(NUM_LOG_TAG, "reversed number");
                    currentNum = 0 - currentNum;
                    setCurrentNum(currentNum);
                }
            }
        });

        delBtn = (Button) view.findViewById(R.id.delBtn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(NUM_LOG_TAG, "clicked on del button");
                if ( !((String) inputTxt.getText()).isEmpty() ) {
                    Log.v(NUM_LOG_TAG, "deleted last char");
                    long newValue = (long) currentNum / 10;
                    setCurrentNum((double) newValue);
                }
            }
        });

        resultTxt = (TextView) view.findViewById(R.id.inputTxt);
        inputTxt = (TextView) view.findViewById(R.id.resultTxt);

        return view;
    }

    private void setOnClickListenerForNumBtn(View view) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                Double btnValue = Double.parseDouble((String) button.getText());
                Log.v(NUM_LOG_TAG, "clicked on " + button.getText());

                if (isTypingNum) {
                    double newValue = currentNum * 10 + btnValue;
                    setCurrentNum(newValue);
                    Log.v(NUM_LOG_TAG, "newValue = " + newValue);
                } else {
                    calculate(currentRes, currentNum, currentOperator);
                    setCurrentRes(currentRes);
                    setCurrentNum(btnValue);
                    Log.v(NUM_LOG_TAG, "currentRes = " + currentRes);
                }

                isTypingNum = true;
            }
        };

        for (Integer id : numBtnID) {
            view.findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOnClickListenerForOperatorBtn(View view) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                Log.v(NUM_LOG_TAG, "clicked on " + button.getText() + " button");

                String displayValue = (String) button.getText();
                try {
                    setCurrentOperator(Operator.findByDisplayValue(displayValue).getOperator());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (isTypingNum) {
                    resultTxt.append(button.getText());
                } else {
                    String temp = (String) resultTxt.getText();
                    String newResultTxt = temp.substring(0, temp.length() - 1) + (String) button.getText();
                    resultTxt.setText(newResultTxt);
                }
                isTypingNum = false;
            }
        };

        for (Integer id : operatorBtnID) {
            view.findViewById(id).setOnClickListener(listener);
        }
    }

    private boolean isEmptyTxtList(String... strings) {
        for (String string : strings) {
            if (!string.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setCurrentOperator(String currentOperator) {
        this.currentOperator = currentOperator;
    }

    public double calculate(double a, double b, String operator) {
        if (operator == null) {
            return b;
        }
        switch (operator) {
            case PLUS:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLE:
                return a * b;
            case DIVIDE:
                try {
                    return a / b;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                return 0;
        }
    }

    public void setCurrentNum(double currentNum) {
        this.currentNum = currentNum;
        if (this.inputTxt != null) {
            this.inputTxt.setText(Double.toString(currentNum));
        }
    }

    public void setCurrentRes(double currentRes) {
        this.currentRes = currentRes;
        if (this.resultTxt != null) {
            this.resultTxt.setText(Double.toString(currentRes));
        }
    }
}
