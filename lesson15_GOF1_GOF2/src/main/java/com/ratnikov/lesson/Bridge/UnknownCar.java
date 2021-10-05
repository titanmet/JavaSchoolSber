package com.ratnikov.lesson.Bridge;

public class UnknownCar extends Car{
    public UnknownCar(Engine engine) {
        super(engine);
    }

    @Override
    public void setEngine() {
        System.out.println("UnknownCar engine: ");
        engine.setEngine();
    }
}
