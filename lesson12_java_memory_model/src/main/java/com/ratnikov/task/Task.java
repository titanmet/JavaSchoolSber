package com.ratnikov.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class Task<T> implements Runnable {
    private final Callable<? extends T> callable;
    ConcurrentHashMap<Callable<? extends T>, Object> objectConcurrentHashMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<Callable<? extends T>, Exception> exceptionConcurrentHashMap = new ConcurrentHashMap<>();

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        if (exceptionConcurrentHashMap.containsKey(callable)) {
            exceptionConcurrentHashMap.get(callable);
        }
        if (objectConcurrentHashMap.containsKey(callable)) {
            synchronized (this) {
                try {
                    objectConcurrentHashMap.put(callable, callable.call());
                } catch (Exception e) {
                    exceptionConcurrentHashMap.put(callable, new TaskException("Ошибка выполнения: " +
                            get().getClass().getSimpleName()));
                    throw exceptionConcurrentHashMap.get(callable);
                }
            }
        }

        return (T) objectConcurrentHashMap.get(callable);
    }

    @Override
    public void run() {
        try {
            this.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
