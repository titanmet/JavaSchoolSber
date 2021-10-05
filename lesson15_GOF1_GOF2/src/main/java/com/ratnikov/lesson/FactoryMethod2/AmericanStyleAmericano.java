package com.ratnikov.lesson.FactoryMethod2;

public class AmericanStyleAmericano extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Американского Americano");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Американского Americano");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Американского Americano"); // наливаем в чашку
    }
}
