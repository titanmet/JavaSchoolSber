package com.ratnikov.lesson.concurrent.ReminderMessage;

public class Reminder implements Runnable{
    @Override
    public void run() {
        System.out.println("Необходимо прогуляться !!!");
        System.out.printf("Thread: %s \n", Thread.currentThread().getName());
    }
}
