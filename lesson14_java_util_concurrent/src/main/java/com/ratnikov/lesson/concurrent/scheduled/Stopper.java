package com.ratnikov.lesson.concurrent.scheduled;

import java.util.concurrent.ExecutorService;

public class Stopper implements Runnable {
    ExecutorService service;

    public Stopper(ExecutorService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("Stopping");
        service.shutdown();
    }
}
