package com.ratnikov.lesson;

public class YieldExample extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " before yield");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " after yield");
    }

    public static void main(String[] args) {
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();
        new YieldExample().start();

    }
}
