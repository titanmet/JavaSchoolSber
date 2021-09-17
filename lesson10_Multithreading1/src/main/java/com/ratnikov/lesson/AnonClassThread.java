package com.ratnikov.lesson;

public class AnonClassThread {
    public static void main(String[] args) throws InterruptedException {
        Thread task = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
                }
            }
        });

        Thread task1 = new Thread(()->{
            System.out.println(String.format("thread %s is running", Thread.currentThread().getName()));
            System.out.println();
        });

        task.start();
        task.join();
        task1.start();
    }
}
