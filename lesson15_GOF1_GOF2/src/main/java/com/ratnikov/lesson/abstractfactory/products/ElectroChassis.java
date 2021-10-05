package com.ratnikov.lesson.abstractfactory.products;

public class ElectroChassis implements Chassis {
    @Override
    public String getChassisParts() {
        return "Electro Chassis build";
    }
}
