package com.ratnikov.executionmanager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " - " + Thread.currentThread().getState());
        });
        Thread.sleep(500);
        thread.start();
        thread.interrupt();
        ExecutionManagerImpl executionManager = new ExecutionManagerImpl();
        executionManager.execute(() -> {
            System.out.println("Callback");
        }, thread);
    }
}
