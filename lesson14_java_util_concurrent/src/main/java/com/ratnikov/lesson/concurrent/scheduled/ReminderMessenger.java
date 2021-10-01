package com.ratnikov.lesson.concurrent.scheduled;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderMessenger {
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    public static void main(String args[]) {
        // нет гарантии, на какой Thread попадет задание
        Reminder first = new Reminder("Первый");
        service.scheduleAtFixedRate(first, 0, 3, TimeUnit.SECONDS);
        Reminder second = new Reminder("Второй");
        service.scheduleAtFixedRate(second, 10, 10, TimeUnit.SECONDS);
        service.schedule(new Stopper(service), 25, TimeUnit.SECONDS);
    }
}
