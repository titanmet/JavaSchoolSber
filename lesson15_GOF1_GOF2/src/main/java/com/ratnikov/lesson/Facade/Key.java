package com.ratnikov.lesson.Facade;

public class Key implements Car{
    @Override
    public void start() {
        System.out.println("Вставить ключи");
    }

    @Override
    public void stop() {
        System.out.println("Вынуть ключи");
    }
}
