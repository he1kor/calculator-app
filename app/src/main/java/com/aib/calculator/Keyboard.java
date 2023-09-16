package com.aib.calculator;

import android.app.Activity;
import android.widget.Button;

public class Keyboard{
    Button buttonClear;
    Button buttonBack;
    Button button7;
    Button button8;
    Button button9;
    Button button4;
    Button button5;
    Button button6;
    Button button1;
    Button button2;
    Button button3;
    Button button0;
    Button buttonDecimal;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonSubtract;
    Button buttonAdd;
    Button buttonEquals;

    public Keyboard(Activity activity) {
        buttonClear = activity.findViewById(R.id.ButtonClear);
        buttonBack = activity.findViewById(R.id.ButtonBack);
        button7 = activity.findViewById(R.id.button7);
        button8 = activity.findViewById(R.id.button8);
        button9 = activity.findViewById(R.id.button9);
        button4 = activity.findViewById(R.id.button4);
        button5 = activity.findViewById(R.id.button5);
        button6 = activity.findViewById(R.id.button6);
        button1 = activity.findViewById(R.id.button1);
        button2 = activity.findViewById(R.id.button2);
        button3 = activity.findViewById(R.id.button3);
        button0 = activity.findViewById(R.id.button0);
        buttonDecimal = activity.findViewById(R.id.buttonDecimal);
        buttonDivide = activity.findViewById(R.id.buttonDivide);
        buttonMultiply = activity.findViewById(R.id.buttonMultiply);
        buttonSubtract = activity.findViewById(R.id.buttonSubtract);
        buttonAdd = activity.findViewById(R.id.buttonAdd);
        buttonEquals = activity.findViewById(R.id.buttonEquals);
    }

    public void setListener(KeyboardListener listener){
        buttonClear.setOnClickListener(view -> listener.onButtonClearClick());
        buttonBack.setOnClickListener(view -> listener.onButtonBackClick());
        button7.setOnClickListener(view -> listener.onButtonDigitClick(Digit.SEVEN));
        button8.setOnClickListener(view -> listener.onButtonDigitClick(Digit.EIGHT));
        button9.setOnClickListener(view -> listener.onButtonDigitClick(Digit.NINE));
        button4.setOnClickListener(view -> listener.onButtonDigitClick(Digit.FOUR));
        button5.setOnClickListener(view -> listener.onButtonDigitClick(Digit.FIVE));
        button6.setOnClickListener(view -> listener.onButtonDigitClick(Digit.SIX));
        button1.setOnClickListener(view -> listener.onButtonDigitClick(Digit.ONE));
        button2.setOnClickListener(view -> listener.onButtonDigitClick(Digit.TWO));
        button3.setOnClickListener(view -> listener.onButtonDigitClick(Digit.THREE));
        button0.setOnClickListener(view -> listener.onButtonDigitClick(Digit.ZERO));
        buttonDecimal.setOnClickListener(view -> listener.onButtonDecimalClick());
        buttonDivide.setOnClickListener(view -> listener.onButtonOperatorClick(Operator.DIVIDE));
        buttonMultiply.setOnClickListener(view -> listener.onButtonOperatorClick(Operator.MULTIPLY));
        buttonSubtract.setOnClickListener(view -> listener.onButtonOperatorClick(Operator.MINUS));
        buttonAdd.setOnClickListener(view -> listener.onButtonOperatorClick(Operator.PLUS));
        buttonEquals.setOnClickListener(view -> listener.onButtonEqualsClick());
    }
}
