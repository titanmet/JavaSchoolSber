package com.ratnikov.lesson.concurrent.lock;

import com.ratnikov.lesson.metric.Meter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Readers and writers
 */
public class ReadWriteLockExample {
    private static Lock reentrantLock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    private static Lock fakeLock = new FakeLock();

    private static List<String> items = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        Meter.execute("fakeLock", () -> {
            doWork(threadPool, fakeLock, fakeLock);
        });
        Meter.execute("reentrantLock", () -> {
            doWork(threadPool, reentrantLock, reentrantLock);
        });
        Meter.execute("readWriteLock", () -> {
            doWork(threadPool, readWriteLock.writeLock(), readWriteLock.readLock());
        });
        threadPool.shutdown();
        Meter.printTimings();
    }

    private static void doWork(ExecutorService threadPool, Lock writersLock, Lock readersLock) {
        List<Future> workers = new ArrayList<>();
        List<Future> writers = startWriters(threadPool, writersLock);
        List<Future> readers = startReaders(threadPool, readersLock);
        workers.addAll(writers);
        workers.addAll(readers);
        workers.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                // do nothing;
            }
        });
    }

    private static List<Future> startReaders(ExecutorService threadPool, Lock lock) {
        List<Future> readers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Future<?> reader = threadPool.submit(new Reader(items, lock));
            readers.add(reader);
        }
        return readers;
    }

    private static List<Future> startWriters(ExecutorService threadPool, Lock lock) {
        List<Future> writers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Future<?> writer = threadPool.submit(new Writer(items, lock));
            writers.add(writer);
        }
        return writers;
    }
}
