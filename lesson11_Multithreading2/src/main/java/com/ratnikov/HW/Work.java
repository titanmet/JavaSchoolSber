package com.ratnikov.HW;

import java.util.LinkedList;

public class Work extends Thread {
    private final LinkedList linkedList;
    private boolean stop = false;


    public Work(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public void run() {
        Runnable runnable;

        while (!isStop()) {
            synchronized (linkedList) {
                while (linkedList.isEmpty()) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException exception) {
                    }
                }
                runnable = (Runnable) linkedList.removeFirst();
                stop = true;
            }
            runnable.run();
        }
    }

    public synchronized boolean isStop() {
        return stop;
    }
}
