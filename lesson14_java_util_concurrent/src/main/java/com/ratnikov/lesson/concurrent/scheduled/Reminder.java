package com.ratnikov.lesson.concurrent.scheduled;

import java.time.LocalDateTime;

public class Reminder implements Runnable {
    private String name;

    public Reminder(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] " + name);
    }
}
