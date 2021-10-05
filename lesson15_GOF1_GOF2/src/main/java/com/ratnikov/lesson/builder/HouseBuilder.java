package com.ratnikov.lesson.builder;

public class HouseBuilder implements Builder {
    private House house;

    @Override
    public void reset() {
        house = new House();
    }

    @Override
    public void perpare() {
        System.out.println("Подготовка фундамента");
        house.setBase(true);
    }

    @Override
    public void mainWork() {
        System.out.println("Возведение дома");
        house.setBuilding(true);
    }

    @Override
    public void addServiceLines() {
        System.out.println("Подключение коммуникаций");
        house.setServiceLines(true);

    }

    @Override
    public void finsish() {
        System.out.println("Отделка");
        house.setFinish(true);
    }

    public House getResult() {
        return house;
    }
}
