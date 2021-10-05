package com.ratnikov.lesson.Singleton;

public class Singleton6 {
    private Singleton6() {
        System.out.println("Singleton 6 created");
    }

    public static final Singleton6 instance = new Singleton6();
}
