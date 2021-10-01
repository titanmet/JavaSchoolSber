package com.ratnikov.lesson.concurrent.ReminderMessage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderMessages {
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        Reminder reminder = new Reminder();
        service.scheduleAtFixedRate(reminder,1,45, TimeUnit.SECONDS);
    }
}
