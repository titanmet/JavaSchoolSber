package com.ratnikov.lesson.Facade;

public class Engine implements Car{
    @Override
    public void start() {
        System.out.println("Запустить двигатель");
    }

    @Override
    public void stop() {
        System.out.println("Остановить двигатель");
    }
}
