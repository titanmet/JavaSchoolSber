package com.ratnikov.lesson.FactoryMethod2;

public class AmericanStyleCappuccino extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Американского Cappuccino");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Американского Cappuccino");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Американского Cappuccino"); // наливаем в чашку
    }
}
