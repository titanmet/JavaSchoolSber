package com.ratnikov.lesson.concurrent.latch.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class BarrierExample {
    AtomicInteger num;
    public static void main(String[] args) throws InterruptedException {
        Runnable action = () -> System.out.println("На старт!");
        CyclicBarrier barrier = new CyclicBarrier(3, action);
        Runnable task = () -> {
            try {
                barrier.await();
                System.out.println("Finished");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println("Limit: " + barrier.getParties());
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }

    }
}
