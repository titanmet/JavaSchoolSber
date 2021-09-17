package com.ratnikov.lesson;

public class ExampleDaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread myDaemon = new MyDaemon();
        myDaemon.start();
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("hello");
    }
}

class MyDaemon extends Thread {
    public MyDaemon() {
        super();
        setDaemon(true);
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(String.format("number %d", i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Finally is Daemon");
            }
        }
    }
}
