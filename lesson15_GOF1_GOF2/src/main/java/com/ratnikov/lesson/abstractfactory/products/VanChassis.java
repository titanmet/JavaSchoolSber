package com.ratnikov.lesson.abstractfactory.products;

public class VanChassis implements Chassis {
    @Override
    public String getChassisParts() {
        return "Van Chassis build";
    }
}
