package com.aib.calculator;

public enum Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    public String getStringValue(){
        switch (this){
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case DIVIDE:
                return "/";
            case MULTIPLY:
                return " * ";
            default:
                throw new RuntimeException("Unknown operator!");
        }
    }
}
