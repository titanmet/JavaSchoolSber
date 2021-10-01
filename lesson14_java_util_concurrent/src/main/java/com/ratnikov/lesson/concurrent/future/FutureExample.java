package com.ratnikov.lesson.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<String> future = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName() + " working...");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " done");
            return "42";
        });
        executor.execute(future);
        String result;
        System.out.println(Thread.currentThread().getName() + " before");
        try {
            result = future.get();
            // что напечатается раньше: done или after?
            System.out.println(Thread.currentThread().getName() + " after");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        System.out.println("result is: " + result);
        executor.shutdown();
        System.out.println("ending");
    }
}
