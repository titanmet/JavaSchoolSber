package com.ratnikov.lesson.abstractfactory;

import com.ratnikov.lesson.abstractfactory.products.*;

public class AppCarFactory {
    public static void main(String[] args) {
        AppCarFactory appCarFactory = new AppCarFactory();

        appCarFactory.createCar(new VanVehicleFactoryImpl());
        System.out.println();
        appCarFactory.createCar(new CarVehicleFactoryImpl());
        System.out.println();
        appCarFactory.createCar(new ElectroVehicleFactoryImpl());
    }

    private void createCar(VehicleFactory vehicleFactory) {
        Body body = vehicleFactory.createBody();
        Engine engine = vehicleFactory.createEngine();
        Chassis chassis = vehicleFactory.createChassis();

        System.out.println("The vehicle was created");

        System.out.println(body.getBodyParts());
        System.out.println(engine.getEngineParts());
        System.out.println(chassis.getChassisParts());
    }
}
