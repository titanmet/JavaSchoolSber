package com.ratnikov.lesson.concurrent.lock;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.Lock;

public class Writer implements Runnable {
    private List<String> items;
    private final Lock lock;
    private static Random random = new SecureRandom();

    public Writer(List<String> items, Lock lock) {
        this.items = items;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            lock.lock();
            sleep(random.nextInt(5));
            items.add(UUID.randomUUID().toString());
            lock.unlock();
            System.out.println("put by " + Thread.currentThread().getName());
        }
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
