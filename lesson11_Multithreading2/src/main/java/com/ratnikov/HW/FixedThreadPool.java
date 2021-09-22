package com.ratnikov.HW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FixedThreadPool implements ThreadPool {
    private final int numThreads;
    private final List<Thread> threads;
    private final LinkedList linkedList;
    private boolean stop = false;

    public FixedThreadPool(int numThreads) {
        this.numThreads = numThreads;
        linkedList = new LinkedList();
        threads = new ArrayList<>(numThreads);
    }
    
    @Override
    public void start() {
        for (int i = 0; i < numThreads; i++) {
            threads.add(new Work(linkedList));
        }

        for(Thread thread: threads) {
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (linkedList) {
            linkedList.addLast(runnable);
            linkedList.notify();
        }
    }
}
