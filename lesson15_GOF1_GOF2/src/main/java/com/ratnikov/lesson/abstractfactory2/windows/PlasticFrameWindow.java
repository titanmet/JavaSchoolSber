package com.ratnikov.lesson.abstractfactory2.windows;

public class PlasticFrameWindow implements Window{
    @Override
    public void open() {
        System.out.println("Открыли пластиковое окно");

    }

    @Override
    public void close() {
        System.out.println("Закрыли пластиковое окно");
    }

    @Override
    public Window install() {
        System.out.println("Установили пластиковое окно");
        return this;
    }
}
