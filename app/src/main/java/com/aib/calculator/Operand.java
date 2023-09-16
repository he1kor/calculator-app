package com.aib.calculator;

import java.util.ArrayList;

public class Operand {

    private ArrayList<Digit> value;
    private boolean isDecimal;
    private boolean isNegative;

    private int minFractionalDigit;

    public Operand(){
        value = new ArrayList<>();
        isDecimal = false;
        isNegative = false;
        minFractionalDigit = 1;
    }
    private Operand(ArrayList<Digit> digits, boolean isDecimal, boolean isNegative, int minFractionalDigit){
        this.value = digits;
        this.isDecimal = isDecimal;
        this.isNegative = isNegative;
        this.minFractionalDigit = minFractionalDigit;
    }
    public static Operand fromDouble(double value){
        String stringValue = String.format("%.3f", value);
        ArrayList<Digit> digits = new ArrayList<>();
        int minFractionalDigit = 1;
        for (int i = stringValue.length() - 1; i > 0; i--){
            if (stringValue.charAt(i) == '.'){
                break;
            }
            minFractionalDigit++;
        }
        for (int i = 0; i < stringValue.length(); i++){
            if (i == stringValue.length() - minFractionalDigit || (value < 0 && i == 0)){
                continue;
            }
            digits.add(Digit.fromString(stringValue.charAt(i)));
        }
        return new Operand(digits, true, value < 0,minFractionalDigit);
    }

    public String getStringValue() {
        StringBuilder result = new StringBuilder();
        if (isNegative){
            result.append("-");
        }
        for (int i = 0; i < value.size(); i++){
            result.append(value.get(i).getStringValue());
            if (isDecimal && i == value.size() - minFractionalDigit)
                result.append(".");
        }
        return result.toString();
    }
    public double getDoubleValue(){
        double result = 0;
        for (int i = 1; i <= value.size(); i++){
            result += Math.pow(10, i - minFractionalDigit) * value.get(value.size() - i).getIntValue();
        }
        if (isNegative){
            result = -result;
        }
        return result;
    }

    public void addDigit(Digit digit) {
        if (isDecimal){
            minFractionalDigit++;
        }
        value.add(digit);
    }
    public void addPoint(){
        insertPoint(value.size() - 1);
    }
    public void insertPoint(int n){
        if (isDecimal){
            throw new RuntimeException("Point is already in number!");
        }
        isDecimal = true;
        minFractionalDigit = value.size() - n;
    }

    public void removeDigit(int n){
        if (isDecimal){
            if (value.size() - minFractionalDigit == n){
                isDecimal = false;
                return;
            }
            if (value.size() - minFractionalDigit < n){
                minFractionalDigit--;
            }
        }
        value.remove(n);
    }
    public void removeLastDigit(){
        if (value.size() == 0) {
            return;
        }
        removeDigit(value.size()-1);
    }
    public void makeNegative(){
        isNegative = true;
    }
    public void makePositive(){
        isNegative = false;
    }

    public boolean isDecimal() {
        return isDecimal;
    }

    public int length(){
        return value.size();
    }

    public int getMinFractionalDigit() {
        return minFractionalDigit;
    }

    public boolean isNegative() {
        return isNegative;
    }
}
