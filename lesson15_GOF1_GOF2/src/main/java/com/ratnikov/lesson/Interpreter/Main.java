package com.ratnikov.lesson.Interpreter;

public class Main {
    public static void main(String[] args) {
        String str = "TesT";
        Context context = new Context();
        Expression loverExpression = new LoverExpression(str);
        str = loverExpression.interpret(context);
        System.out.println(str);
        Expression upperExpression = new UpperExpression(str);
        str = upperExpression.interpret(context);
        System.out.println(str);
    }
}
