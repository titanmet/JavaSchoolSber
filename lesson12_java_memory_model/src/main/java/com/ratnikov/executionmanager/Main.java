package com.ratnikov.executionmanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + Thread.currentThread().getState());
        });
        thread.start();
        Thread.sleep(100);
        ExecutionManagerImpl executionManager = new ExecutionManagerImpl();
        executionManager.execute(() -> {
            System.out.println("Callback");
        }, thread);
    }
}
