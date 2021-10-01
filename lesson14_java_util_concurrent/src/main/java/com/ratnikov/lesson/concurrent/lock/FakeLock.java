package com.ratnikov.lesson.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class FakeLock implements Lock {

    @Override
    public void lock() {
        // do nothing
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // do nothing
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        // do nothing
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
