package com.ratnikov.HW1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.ratnikov.HW1.aspect.*.call*(..))")
//    @Pointcut("execution(* com.ratnikov.HW1.aspect.MyService.call*(..))")
//    @Pointcut("execution(* com.ratnikov.HW1.aspect.MyService.*(..))")
    public void callAtMyServicePublic() {
    }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        System.out.println("before " + jp.toString() + ", args=[" + args + "]");
    }

//    @Before("callAtMyServicePublic()")
//    public void beforeCallAtMethod1() {
//        System.out.println("before ");
//    }

//    @AfterReturning(pointcut = "callAtMyServicePublic()", returning = "someValue")
//    public void afterReturningAdvice(Object someValue) {
//        System.out.println("Value: "+ someValue.toString());
//    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        System.out.println("\"after \" + jp.toString()");
    }
}
