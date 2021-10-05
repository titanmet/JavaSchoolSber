package com.ratnikov.lesson.abstractfactory;

import com.ratnikov.lesson.abstractfactory.products.*;

public class VanVehicleFactoryImpl implements VehicleFactory {
    @Override
    public Body createBody() {
        return new VanBody();
    }

    @Override
    public Engine createEngine() {
        return new VanEngine();
    }

    @Override
    public Chassis createChassis() {
        return new VanChassis();
    }
}
