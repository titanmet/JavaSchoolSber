package com.ratnikov.lesson.builder;

public class Main {
    public static void main(String[] args) {
        PriceBuilder priceBuilder = new PriceBuilder();
        HouseBuilder houseBuilder = new HouseBuilder();
        DocBuilder docBuilder = new DocBuilder();

        Director salesman = new Director(priceBuilder); // продвец
        Director manager = new Director(docBuilder); // менеджер
        Director foreman = new Director(houseBuilder); // прораб

        salesman.make(true);
        int price = priceBuilder.getResult();
        System.out.printf("Результат работы продавца - цена: %d\n\n", price);

        foreman.make(true);
        House house = houseBuilder.getResult();
        System.out.printf("Результат работы прораба - дом:\n%s\n", house);

        manager.make(true);
        Documentation doc = docBuilder.getResult();
        System.out.printf("Результат работы менеджера - пакет документов:\n%s\n", doc);

    }
}
