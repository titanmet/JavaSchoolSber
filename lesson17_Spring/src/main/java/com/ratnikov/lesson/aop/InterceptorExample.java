package com.ratnikov.lesson.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class InterceptorExample implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Method " + invocation.getMethod().getName() + " is called");
        final Object result = invocation.proceed();
        System.out.println("Method " + invocation.getMethod().getName() + " return value " + result);
        return result;
    }
}
