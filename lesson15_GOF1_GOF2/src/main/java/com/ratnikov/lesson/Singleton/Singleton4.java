package com.ratnikov.lesson.Singleton;

public class Singleton4 {
    private Singleton4() {
        System.out.println("Singleton 4 created");
    }

    private volatile static Singleton4 instance; // problems without volatile (reorder)

    public static  Singleton4 getInstance() {
        if (instance == null)
            synchronized (Singleton4.class) {
                if (instance == null)
                    instance = new Singleton4();
            }

        return instance;
    }
}
