package com.ratnikov.lesson.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * тот же пример, что и с future
 */
public class RunnableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " working...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " done");
        };
        System.out.println(Thread.currentThread().getName() + " before");
        executor.execute(runnable);
        System.out.println(Thread.currentThread().getName() + " after");
        // что напечатается раньше: done или after?
        executor.shutdown();
        System.out.println("ending");
    }
}
