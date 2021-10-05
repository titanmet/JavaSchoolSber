package com.ratnikov.lesson.Decorator;

public class Chakra extends OptionDecorator{
    public Chakra(Service service) {
        super(service, "Chakra", 1000);
    }
}
