package com.ratnikov.lesson.concurrent.lock;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static Set<String> names = new HashSet<>();
    private static Set<Future> futures = new HashSet<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Lock lock = new ReentrantLock();
        futures.add(service.submit(new Task(lock)));
        futures.add(service.submit(new Task(lock)));
        futures.add(service.submit(new Task(lock)));
        // waiting
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                log("exception %s", e);
            }
        });
        log("final map: %s", names);
        service.shutdown();
    }

    static class Task implements Callable<String> {
        Lock lock;

        Task(Lock lock) {
            this.lock = lock;
        }

        @Override
        public String call() throws Exception {
            String name = Thread.currentThread().getName();
            log("Before lock for %s", name);
            lock.lock(); // comment this
            log("Locked for %s", name);
            TimeUnit.SECONDS.sleep(1);
            try {
                names.add(name);
                log("Name added: %s", name);
                log("Map: %s", names);
                TimeUnit.SECONDS.sleep(1);
            } finally {
                lock.unlock(); // comment this
                log("Lock released for %s", name);
            }
            return name;
        }
    }

    private static void log(String pattern, Object... args) {
        System.out.println("[" + LocalDateTime.now().toString() + "] " + String.format(pattern, args));
    }
}
