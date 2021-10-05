package com.ratnikov.lesson.Singleton;

public class Singleton1 {
    private Singleton1() {
        System.out.println("Singleton 1 created");
    }

    private static Singleton1 instance;

    public static Singleton1 getInstance() {
        if (instance == null)
            instance = new Singleton1();

        return instance;
    }

}
