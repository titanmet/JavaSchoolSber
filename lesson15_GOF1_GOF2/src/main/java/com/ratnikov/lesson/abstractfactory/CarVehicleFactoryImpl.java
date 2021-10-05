package com.ratnikov.lesson.abstractfactory;

import com.ratnikov.lesson.abstractfactory.products.*;

public class CarVehicleFactoryImpl implements VehicleFactory {
    @Override
    public Body createBody() {
        return new CarBody();
    }

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Chassis createChassis() {
        return new CarChassis();
    }
}
