package com.aib.calculator;

import java.util.ArrayList;

public class MathExpression {
    private final ArrayList<Operand> operands;
    private final ArrayList<Operator> operators;
    private boolean isOperandEnded;

    public MathExpression() {
        isOperandEnded = false;
        operators = new ArrayList<>();
        operands = new ArrayList<>();
    }

    public boolean addOperand(Operand operand){
        if (!isOperandEnded){
            operands.add(operand);
            isOperandEnded = true;
            return true;
        }
        return false;
    }

    public boolean addOperator(Operator operator){
        if (isOperandEnded){
            operators.add(operator);
            isOperandEnded = false;
            return true;
        }
        return false;
    }
    public boolean changeLastOperator(Operator operator){
        if (isOperandEnded)
            return false;
        if (operators.size() == 0)
            return false;
        operators.remove(getOperatorsCount()-1);
        operators.add(operator);
        return true;
    }

    public boolean changeLastOperand(Operand operand){
        if (!isOperandEnded)
            return false;
        operands.remove(getOperandsCount()-1);
        operands.add(operand);
        return true;
    }

    public void removeLastValue(){
        if (operands.size() == 0)
            return;
        if (isOperandEnded){
            operands.remove(getOperandsCount()-1);
        } else {
            operators.remove(getOperatorsCount()-1);
        }
        isOperandEnded = !isOperandEnded;
    }

    public void clear(){
        operands.clear();
        operators.clear();
        isOperandEnded = false;
    }

    public Operand getOperand(int n){
        return operands.get(n);
    }

    public Operator getOperator(int n){
        return operators.get(n);
    }

    public Operand getLastOperand(){
        return operands.get(getOperandsCount()-1);
    }
    public Operator getLastOperator(){
        return operators.get(getOperatorsCount()-1);
    }

    public int getOperandsCount(){
        return operands.size();
    }

    public int getOperatorsCount(){
        return operators.size();
    }

    public boolean isOperandEnded() {
        return isOperandEnded;
    }

    public String getStringExpression(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < getOperandsCount(); i++){
            result.append(operands.get(i).getStringValue());
            if (i == getOperatorsCount())
                break;
            result.append(operators.get(i).getStringValue());
        }
        return result.toString();
    }
    public double calculate(){
        if (getOperandsCount() == 0){
            return 0;
        }
        double result = getOperand(0).getDoubleValue();
        for (int i = 0; i < getOperandsCount()-1; i++){
            result = operation(result, getOperator(i), getOperand(i+1).getDoubleValue());
        }
        return result;
    }

    public static double operation(double operand1, Operator operator, double operand2){
        switch (operator) {
            case DIVIDE:
                return operand1 / operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case MINUS:
                return operand1 - operand2;
            case PLUS:
                return operand1 + operand2;
            default:
                throw new RuntimeException("Unknown operation!");

        }
    }
}
