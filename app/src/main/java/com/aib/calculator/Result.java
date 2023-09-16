package com.aib.calculator;

import android.app.Activity;
import android.widget.TextView;

public class Result implements CalculationListener {

    private TextView resultText;

    public Result(Activity activity) {
        resultText = activity.findViewById(R.id.TextResult);
    }

    @Override
    public void onResult(String result) {
        resultText.setText(result);
    }
}
