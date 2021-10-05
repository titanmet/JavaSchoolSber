package com.ratnikov.lesson.Interpreter;

public class LoverExpression implements Expression {
    private String s;
    public LoverExpression(String s) {
        this.s = s;
    }
    public String interpret(Context context) {
        return context.getLoverCase(s);
    }
}
