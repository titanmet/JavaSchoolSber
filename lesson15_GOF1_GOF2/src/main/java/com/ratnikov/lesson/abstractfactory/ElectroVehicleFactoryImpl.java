package com.ratnikov.lesson.abstractfactory;

import com.ratnikov.lesson.abstractfactory.products.*;

public class ElectroVehicleFactoryImpl implements VehicleFactory {
    @Override
    public Body createBody() {
        return new ElectroBody();
    }

    @Override
    public Engine createEngine() {
        return new ElectroEngine();
    }

    @Override
    public Chassis createChassis() {
        return new ElectroChassis();
    }
}
