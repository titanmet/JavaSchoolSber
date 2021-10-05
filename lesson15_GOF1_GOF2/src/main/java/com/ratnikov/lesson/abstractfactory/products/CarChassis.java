package com.ratnikov.lesson.abstractfactory.products;

public class CarChassis implements Chassis {
    @Override
    public String getChassisParts() {
        return "Car Chassis build";
    }
}
