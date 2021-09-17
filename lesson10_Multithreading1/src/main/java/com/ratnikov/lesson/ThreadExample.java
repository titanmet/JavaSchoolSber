package com.ratnikov.lesson;

public class ThreadExample extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new ThreadExample().start();
        new ThreadExample().start();
        new ThreadExample().start();
        System.out.println(new ThreadExample().getPriority());
    }
}
