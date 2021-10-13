package com.ratnikov.lesson.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterReturningExample implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice");
    }
}
