package com.ratnikov.lesson.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class rt {
    private static Integer sum = 0;

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyRunnable(1));
        Thread th2 = new Thread(new MyRunnable(2));
        Thread th3 = new Thread(new MyRunnable(3));

        th1.start();
        th2.start();
        th3.start();
    }

    public static Lock lock = new ReentrantLock();

    private static class MyRunnable implements Runnable {
        private final int num;

        public MyRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                lock.tryLock();
                sum += 1;
                System.out.println("sum = " + sum + ", Thread = " + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }

        public int getNum() {
            return num;
        }
    }
}


