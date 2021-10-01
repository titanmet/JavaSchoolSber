package com.ratnikov.lesson.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> f = executorService.submit(() -> {
            try {
                System.out.println("Перед засыпанием = ");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("args =");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        });

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Task 1");
//            }
//        };
//        String result = "123";
//        Future<String> f = executorService.submit(runnable, result);


        try {
            System.out.println("f.isDone() = " + f.isDone());
            System.out.println("f.isCancelled() = " + f.isCancelled());
//        System.out.println("f.cancel() = "+f.cancel(true));
            System.out.println("f.get() = " + f.get());
            System.out.println("2 f.isDone() = " + f.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
