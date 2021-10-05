package com.ratnikov.lesson.abstractfactory2.roofs;

public class WoodRoof implements Roof {
    @Override
    public Roof cover() {
        System.out.println("-покрыли деревянную крышу");
        return this;
    }

    @Override
    public void waterProtect() {
        System.out.println("—делали гидроизоляцию деревянной крыши");

    }
}
