package com.ratnikov.lesson.abstractfactory2.roofs;

public class TileRoof implements Roof {
    @Override
    public Roof cover() {
        System.out.println("-покрыли крышу из черепицы");
        return this;
    }

    @Override
    public void waterProtect() {
        System.out.println("—делали гидроизоляцию черепичной крыши");
    }

}
