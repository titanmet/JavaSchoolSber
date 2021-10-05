package com.ratnikov.lesson.Decorator;

public class Horoscope implements Service{
    private String label;
    private double price;

    public Horoscope(String label, double price) {
        this.label = label;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getLabel() {
        return this.label;
    }
}
