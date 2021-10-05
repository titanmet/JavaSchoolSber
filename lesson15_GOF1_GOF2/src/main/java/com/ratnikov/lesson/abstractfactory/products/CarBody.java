package com.ratnikov.lesson.abstractfactory.products;

public class CarBody implements Body {
    @Override
    public String getBodyParts() {
        return  "Car Body build";
    }
}
