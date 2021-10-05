package com.ratnikov.lesson.abstractfactory.products;

public class CarEngine implements Engine {
    @Override
    public String getEngineParts() {
        return "Car Engine build";
    }
}
