package com.ratnikov.lesson.FactoryMethod2;

public class ItalianStyleAmericano extends Coffee {
    public void grindCoffee(){
        System.out.println("перемалываем кофе Итальянского Американо");// перемалываем кофе
    }
    public void makeCoffee(){
        System.out.println("делаем кофе Итальянского Американо");// делаем кофе
    }
    public void pourIntoCup(){
        System.out.println("наливаем в чашку кофе Итальянского Американо"); // наливаем в чашку
    }
}
