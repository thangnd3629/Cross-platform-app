package com.example.navigationdrawer.ui.calculator;

public enum Operator {
    PLUS("+", "+"),
    SUBTRACT("-", "-"),
    DIVIDE("/", "/"),
    MULTIPLE("*", "*");

    private String operator;
    private String displayValue;

    Operator(String operator, String displayValue) {
        this.operator = operator;
        this.displayValue = displayValue;
    }

    public static Operator findByDisplayValue(String value) throws Exception {
        for (Operator operator : Operator.values()) {
            if (operator.getDisplayValue().equalsIgnoreCase(value)) {
                return operator;
            }
        }
        throw new Exception("Not found operator enum");
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
