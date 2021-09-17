package com.ratnikov.lesson;

public class RunnableExample  {
    public static void main(String[] args) throws InterruptedException {
//        Task task = new Task();
//        task.run();
        for (int i = 0; i < 1_000_000; i++) {
            Thread t = new Thread(new Task());
            t.start();
        }
//        t.join();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
//        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("%d - thread %s is running", i, Thread.currentThread().getName()));
        }
    }
}
