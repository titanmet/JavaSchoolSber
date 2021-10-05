package com.ratnikov.lesson.Decorator;

public class Aura extends OptionDecorator{
    public Aura(Service service) {
        super(service, "Aura", 500);
    }
}
