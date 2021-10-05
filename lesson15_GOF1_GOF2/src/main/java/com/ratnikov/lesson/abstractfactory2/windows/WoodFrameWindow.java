package com.ratnikov.lesson.abstractfactory2.windows;

public class WoodFrameWindow implements Window {
    @Override
    public void open() {
        System.out.println("Открыли деревянное окно");
    }

    @Override
    public void close() {
        System.out.println("Закрыли деревянное окно");
    }

    @Override
    public Window install() {
        System.out.println("Установили деревянное окно");
        return this;
    }
}
