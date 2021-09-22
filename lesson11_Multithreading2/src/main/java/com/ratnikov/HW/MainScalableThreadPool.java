package com.ratnikov.HW;

public class MainScalableThreadPool {
    public static void main(String[] args) {
        ScalableThreadPool threads = new ScalableThreadPool(1, 7);
        threads.start();
        threads.execute(() -> {
            for (int i = 0; i < 7; i++) {
                System.out.println(threads.getClass().getSimpleName() + " - " + i);
            }
        });
        threads.interrupt();
    }
}

