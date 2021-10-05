package com.ratnikov.lesson.FactoryMethod2;

public class ItalianStyleCappuccino extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Итальянского Cappuccino");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Итальянского Cappuccino");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Итальянского Cappuccino"); // наливаем в чашку
    }
}
