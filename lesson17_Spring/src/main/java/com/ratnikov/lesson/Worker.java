package com.ratnikov.lesson;

import com.ratnikov.lesson.configure.ConfigurationLesson;
import com.ratnikov.lesson.fabric.FirstServiceHandler;
import com.ratnikov.lesson.fabric.Handlers;
import com.ratnikov.lesson.fabric.IHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Worker {
    public static void main(String[] args) {
//        FirstServiceHandler handler = new FirstServiceHandler();
//        System.out.println(handler.execute());

//        final ApplicationContext context = new ClassPathXmlApplicationContext("xmlConfig.xml");
//        final IHandler handler = context.getBean(Handlers.findHandlerByCode(args[0]), IHandler.class);
//        final IHandler handler = context.getBean("thirdServiceHandler", IHandler.class);
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationLesson.class);
//        final IHandler handler = context.getBean("firstServiceHandler", IHandler.class);
        final IHandler handler = context.getBean("thirdServiceHandler", IHandler.class);
        final IHandler handler1 = context.getBean("thirdServiceHandler", IHandler.class);
        final IHandler handler2 = context.getBean("thirdServiceHandler", IHandler.class);
        final IHandler handler3 = context.getBean("thirdServiceHandler", IHandler.class);

        System.out.println(handler.execute());
        System.out.println(handler1.execute());
        System.out.println(handler2.execute());
        System.out.println(handler3.execute());

        context.close();
    }
}
