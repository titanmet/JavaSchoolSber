package com.ratnikov.lesson.concurrent.lock;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Reader implements Runnable {
    private List<String> items;
    private final Lock lock;
    private static Random random = new SecureRandom();

    public Reader(List<String> items, Lock lock) {
        this.items = items;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            System.out.println("items.size() == " + items.size());
            if (items.size() > 0) {
                lock.lock();
                String value = items.get(random.nextInt(items.size()));
                sleep(5);
                lock.unlock();
                System.out.println("get " + value + " by " + Thread.currentThread().getName());
            }
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
