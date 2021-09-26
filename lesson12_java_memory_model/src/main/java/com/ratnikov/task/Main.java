package com.ratnikov.task;

import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println(executorService.toString());
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String result = "result default";
                try {
                    Thread.sleep(1000);
                    if (new Random().nextInt(10) == 12) {
                        throw new Exception();
                    }
                    result = "result task";
                    return result;
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupt");
                    return result;
                }
            }
        });

        executorService.execute((Runnable) future);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        executorService.execute((Runnable) future);
        String result = null;
        result = future.get();

        new Thread((Runnable) future).start();
        System.out.println(result + "  - Thread - " + Thread.currentThread().getName());
        System.out.println(executorService.toString());
        executorService.shutdown();
    }
}
