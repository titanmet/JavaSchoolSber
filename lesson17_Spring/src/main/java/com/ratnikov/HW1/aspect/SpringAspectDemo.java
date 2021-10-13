package com.ratnikov.HW1.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAspectDemo {
    public static void main(String[] args) {
        mainMyService();
    }

    private static void mainMyService() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAspectConfig.class);
        MyService aopService = ctx.getBean(MyService.class);
        aopService.callMyService("HELLO");
        aopService.execute("str");

        NotMyService aopService1 = ctx.getBean(NotMyService.class);
        aopService1.call("-----------------");
        aopService1.exec("=================");
    }
}
