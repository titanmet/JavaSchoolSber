package com.ratnikov.lesson;

public class StateExample {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1; i++) {
                System.out.println(String.format("Thread %s is running", Thread.currentThread().getName()));
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                synchronized (object){
                    try {
                        System.out.println(String.format("Thread state before sleep: %s", Thread.currentThread().getName()));
                        Thread.sleep(15000);
                        System.out.println(String.format("Thread state before wait: %s", Thread.currentThread().getName()));
                        object.wait();
                        System.out.println(String.format("Thread state after sleep: %s", Thread.currentThread().getName()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println(String.format("Thread state before start: %s", t1.getState()));
        t1.start();
        Thread.sleep(2000);
//        Thread.sleep(50);
        System.out.println(String.format("Thread state after start: %s", t1.getState()));
        Thread.sleep(2000);
        Thread mainThread = Thread.currentThread();

        Thread t2 = new Thread(()->{
            while (!Thread.interrupted()){
                System.out.println("Main thread state: " + mainThread.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        });
        t2.setDaemon(true);
        t2.start();

        synchronized (object) {
            System.out.println(String.format("Thread state before notify: %s", Thread.currentThread().getName()));
            object.notify();
        }
        Thread.sleep(1000);
        System.out.println(String.format("Thread state after notify: %s", t1.getState()));
    }
}
