package com.ratnikov.HW;

public class MainFixedThreadPool {
    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(10);
        fixedThreadPool.start();
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Task(i));
        }
    }
}
