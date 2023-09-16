package com.aib.calculator;

import android.app.Activity;
import android.widget.TextView;

public class InputField implements KeyboardListener {

    private MathExpression mathExpression;
    private TextView inputView;
    private CalculationListener calculationListener;

    public InputField(Activity activity) {
        this.inputView = activity.findViewById(R.id.TextInput);
        mathExpression = new MathExpression();
    }

    private void update(){
        inputView.setText(mathExpression.getStringExpression());
        if (mathExpression.getOperandsCount() > 0){
            calculationListener.onResult(String.format("%.3f",mathExpression.calculate()));
        } else{
            calculationListener.onResult("");
        }
    }
    public void setCalculationResultListener(CalculationListener calculationListener){
        this.calculationListener = calculationListener;
    }

    @Override
    public void onButtonClearClick() {
        mathExpression.clear();
        update();
    }

    @Override
    public void onButtonBackClick() {
        if (mathExpression.isOperandEnded()){
            Operand operand = mathExpression.getLastOperand();
            int operandLength = operand.length() + (operand.isDecimal()? 1 : 0);
            if (operandLength > 1){
                mathExpression.getLastOperand().removeLastDigit();
                update();
                return;
            }
        }
        mathExpression.removeLastValue();
        update();
    }

    @Override
    public void onButtonDigitClick(Digit digit) {
        if (mathExpression.isOperandEnded()){
            mathExpression.getLastOperand().addDigit(digit);
        } else{
            Operand newOperand = new Operand();
            newOperand.addDigit(digit);
            mathExpression.addOperand(newOperand);
        }
        update();
    }
    @Override
    public void onButtonDecimalClick() {
        if (mathExpression.isOperandEnded()) {
            Operand lastOperand = mathExpression.getLastOperand();
            if (lastOperand.isDecimal())
                return;
            lastOperand.addPoint();
        } else {
            Operand newOperand = new Operand();
            newOperand.addDigit(Digit.ZERO);
            newOperand.addPoint();
            mathExpression.addOperand(newOperand);
        }
        update();
    }

    @Override
    public void onButtonOperatorClick(Operator operator) {
        if (mathExpression.isOperandEnded()){
            mathExpression.addOperator(operator);
        } else{
          mathExpression.changeLastOperator(operator);
        }
        update();
    }

    @Override
    public void onButtonEqualsClick() {
        if (mathExpression.getOperandsCount() == 0)
            return;
        double result = mathExpression.calculate();
        mathExpression = new MathExpression();
        mathExpression.addOperand(Operand.fromDouble(result));
        update();
    }
}
