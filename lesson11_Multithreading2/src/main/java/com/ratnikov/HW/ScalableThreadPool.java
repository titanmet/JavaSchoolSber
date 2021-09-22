package com.ratnikov.HW;

import java.util.ArrayList;
import java.util.LinkedList;


public class ScalableThreadPool implements ThreadPool {
    private int minThreads;
    private int maxThreads;
    private volatile Integer busyPoolCount = 0;
    private ArrayList<Task> threadsTask;
    private LinkedList<Runnable> tasks;
    private volatile boolean isRun = true;
    private final Object threadLock = new Object();

    ScalableThreadPool(int min, int max) {
        this.minThreads = min;
        this.maxThreads = max;
        threadsTask = new ArrayList<>(minThreads);
        tasks = new LinkedList<>();
    }

    public void start() {
        threadsTask.forEach(Thread::start);
    }

    public void execute(Runnable runnable) {
        synchronized (threadLock) {
            tasks.add(runnable);
            if(busyPoolCount >= threadsTask.size()) {
                Task thread = new Task();
                threadsTask.add(thread);
                thread.run();
            }
            threadLock.notify();
        }
    }

    public void interrupt() {
        isRun = false;
        threadsTask.forEach(Task::interrupt);
    }

    private class Task extends Thread {
        @Override
        public void run() {
            while(isRun) {
                final Runnable task;
                synchronized (threadLock) {
                    if(tasks.isEmpty()) {
                        if (threadsTask.size() > minThreads)
                            break;
                        try {
                            threadLock.wait();
                        } catch(InterruptedException e) {
                            interrupt();
                            break;
                        }
                    }
                    task = tasks.poll();
                }
                synchronized (busyPoolCount) {
                    busyPoolCount++;
                }
                task.run();
                synchronized (busyPoolCount) {
                    busyPoolCount--;
                }
            }
        }
    }
}
