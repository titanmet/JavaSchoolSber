package com.ratnikov.lesson.abstractfactory;

import com.ratnikov.lesson.abstractfactory.products.Body;
import com.ratnikov.lesson.abstractfactory.products.Chassis;
import com.ratnikov.lesson.abstractfactory.products.Engine;

public interface VehicleFactory {
    Body createBody();
    Engine createEngine();
    Chassis createChassis();
}
