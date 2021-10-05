package com.ratnikov.lesson.abstractfactory.products;

public class ElectroEngine implements Engine {
    @Override
    public String getEngineParts() {
        return "Electro Engine build";
    }
}
