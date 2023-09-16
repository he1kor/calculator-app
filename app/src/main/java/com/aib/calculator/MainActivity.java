package com.aib.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Keyboard keyboard = new Keyboard(this);
        InputField inputField = new InputField(this);
        keyboard.setListener(inputField);
        Result result = new Result(this);
        inputField.setCalculationResultListener(result);
    }
}