package com.ratnikov.lesson.Command;

public class StopCar implements Command{
    Car car;

    public StopCar(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.stopEngine();
    }
}
