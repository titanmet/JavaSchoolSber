package com.ratnikov.lesson.Decorator;

public class Main {
    public static void main(String[] args) {
        double cost;

        Service taro = new Divination("Taro", 1000);
        Service personalHoroscope = new Horoscope("Personal Horoscope", 9000);
        cost = taro.getPrice() + personalHoroscope.getPrice();
        System.out.println("Standard price : " + cost);

        Service taroHoroscope = new Divination("Taro+Horoscope", 10000);
        Service  chakra = new Chakra(taroHoroscope);
        Service aura = new Aura(chakra);
        System.out.println("Extends price : "+ aura.getPrice());
    }
}
