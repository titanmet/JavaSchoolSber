package com.ratnikov.HW;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    int i;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " - " + i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
