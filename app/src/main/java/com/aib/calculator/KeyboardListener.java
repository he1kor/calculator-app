package com.aib.calculator;

public interface KeyboardListener {
    void onButtonClearClick();
    void onButtonBackClick();
    void onButtonDigitClick(Digit digit);
    void onButtonDecimalClick();
    void onButtonOperatorClick(Operator operator);
    void onButtonEqualsClick();
}
