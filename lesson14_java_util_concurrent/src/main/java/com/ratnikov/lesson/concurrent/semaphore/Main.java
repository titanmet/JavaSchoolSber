package com.ratnikov.lesson.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

   public static void main(String[] args) {

       Semaphore sem = new Semaphore(2);
       new Philosopher(sem,"Сократ").start();
       new Philosopher(sem,"Платон").start();
       new Philosopher(sem,"Аристотель").start();
       new Philosopher(sem,"Фалес").start();
       new Philosopher(sem,"Эпикур").start();
       new Philosopher(sem,"Пифагор").start();
   }
}
