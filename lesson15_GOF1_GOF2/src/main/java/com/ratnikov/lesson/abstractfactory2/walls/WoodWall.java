package com.ratnikov.lesson.abstractfactory2.walls;

public class WoodWall implements Wall {
    @Override
    public void build() {
        System.out.println("—подобрали деревянные стены");

    }
}
