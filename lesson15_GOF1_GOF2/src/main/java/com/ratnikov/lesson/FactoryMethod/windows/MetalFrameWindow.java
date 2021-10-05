package com.ratnikov.lesson.FactoryMethod.windows;

public class MetalFrameWindow implements Window {
    @Override
    public void open() {
        System.out.println("открыли металлическое окно");
    }

    @Override
    public String toString() {
        return "Металлическое окно";
    }
}
