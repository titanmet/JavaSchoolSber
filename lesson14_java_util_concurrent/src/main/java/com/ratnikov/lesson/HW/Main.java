package com.ratnikov.lesson.HW;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        runTasks(Executors.newFixedThreadPool(10));
    }

    @Cache(zip = false)
    private static Runnable getRunnable(long timeOut, int num) {
        Calculator calculator = new CalculatorImpl();
        Calculator taskProxy = (Calculator) ConcurrentCacheProxyImpl.newInstance(calculator);
        AtomicReference<Double> res = new AtomicReference<>((double) 0);
        return ()->{
            List<Thread> threads = IntStream.range(0, 10)
                    .mapToObj(value -> new Thread(() -> {

                        if (value % 2 == 0) {
                            res.set(taskProxy.sum_old(9, 9));
                        }else {
                            res.set(taskProxy.sum_new(10, 0));
                        }
                        System.out.println("RESULT : " + "-" + Thread.currentThread().getName() + "-" + " result = " + res);
                    })).collect(Collectors.toList());
            threads.forEach(Thread::start);
        };
    }

    private static void runTasks(ExecutorService executorService) {
        for (int i = 0; i < 10; i++) {
            executorService.submit(getRunnable((long) 500 + i * 5, i));
        }
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
