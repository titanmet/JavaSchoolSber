package com.ratnikov.lesson;

public class PriorityTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("%s(%d)",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
                    Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new PriorityTest());
            t.setPriority(i % 2 == 0 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);
            t.start();
        }
    }
}
