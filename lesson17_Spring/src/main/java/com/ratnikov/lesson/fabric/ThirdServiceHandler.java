package com.ratnikov.lesson.fabric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ThirdServiceHandler implements IHandler {
    private SingletonLazy singleton;

    @Autowired
    @Qualifier("hh")
    private IHandler handler;

    public ThirdServiceHandler(SingletonLazy singletonLazy) {
        this.singleton = singletonLazy;
    }

    @Override
    public String execute() {
//        return "Third";
        return String.valueOf(singleton.getNextSerial()+ handler.execute());
    }

    @Autowired
    public void setSingletonLazy(SingletonLazy singletonLazy) {
        this.singleton = singletonLazy;
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("PostConstruct");
//    }

//    @PreDestroy
//    public void destroy() {
//        System.out.println("destroy");
//    }
}
