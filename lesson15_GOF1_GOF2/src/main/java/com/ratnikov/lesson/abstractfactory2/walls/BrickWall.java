package com.ratnikov.lesson.abstractfactory2.walls;

public class BrickWall implements Wall {
    @Override
    public void build() {
        System.out.println("—доложили кирпичные стены");

    }
}
