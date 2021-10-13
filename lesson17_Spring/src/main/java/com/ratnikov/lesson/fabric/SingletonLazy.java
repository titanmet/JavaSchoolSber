package com.ratnikov.lesson.fabric;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SingletonLazy {
    private static SingletonLazy INSTANCE;

    private final AtomicInteger count = new AtomicInteger(0);

    public int getNextSerial() {
        return count.incrementAndGet();
    }
}
