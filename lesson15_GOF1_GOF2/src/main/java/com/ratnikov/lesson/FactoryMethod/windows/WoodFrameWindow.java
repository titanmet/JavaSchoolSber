package com.ratnikov.lesson.FactoryMethod.windows;

public class WoodFrameWindow implements Window {
    @Override
    public void open() {
        System.out.println("Открыли деревянное окно");
    }

    @Override
    public String toString() {
        return "Деревянное окно";
    }
}
