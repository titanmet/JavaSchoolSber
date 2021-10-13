package com.ratnikov.lesson.aop;

import com.ratnikov.lesson.fabric.FirstServiceHandler;
import com.ratnikov.lesson.fabric.IHandler;
import org.springframework.aop.framework.ProxyFactory;

public class Intercept {
    public static void main(String[] args) {
        final IHandler handler = new FirstServiceHandler();
        final ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new BeforeExample());
        pf.addAdvice(new InterceptorExample());
        pf.addAdvice(new AfterReturningExample());
        pf.setTarget(handler);

        IHandler handlerProxy = (FirstServiceHandler) pf.getProxy();
        handlerProxy.execute();
    }
}
