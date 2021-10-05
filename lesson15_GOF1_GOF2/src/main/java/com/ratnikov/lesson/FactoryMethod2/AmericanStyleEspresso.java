package com.ratnikov.lesson.FactoryMethod2;

public class AmericanStyleEspresso extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Американского Espresso");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Американского Espresso");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Американского Espresso"); // наливаем в чашку
    }
}
