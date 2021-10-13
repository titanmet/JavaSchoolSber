package com.ratnikov.lesson;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Parser {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expr = parser.parseExpression("toUpperCase().substring(1,5)");
        EvaluationContext ctx = new StandardEvaluationContext("Hello world");
        String result = expr.getValue(ctx, String.class);
        System.out.println(result);
    }
}
