package com.ratnikov.lesson.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    static volatile AtomicInteger flag = new AtomicInteger(1);
    public static void main(String[] args) {
        Object mutex = new Object();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                synchronized (mutex) {
                    if (flag.get() == 1) {
                        System.out.println(Thread.currentThread().getName() + " true");
                        int get = flag.getAndDecrement();
                        System.out.println(Thread.currentThread().getName() + " value = " + get);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " false");
                        int get = flag.getAndIncrement();
                        System.out.println(Thread.currentThread().getName() + " value = " + get);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // do nothing
                }
            });
        }
        executorService.shutdown();
    }
}
