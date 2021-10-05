package com.ratnikov.lesson.FactoryMethod2;

public class ItalianStyleEspresso extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Итальянского Espresso");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Итальянского Espresso");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Итальянского Espresso"); // наливаем в чашку
    }
}
