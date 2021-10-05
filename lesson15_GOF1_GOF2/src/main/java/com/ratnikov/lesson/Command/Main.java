package com.ratnikov.lesson.Command;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        StartCar startCar = new StartCar(car);
        CarInvoker carInvoker = new CarInvoker(startCar);
        carInvoker.execute();
    }
}
