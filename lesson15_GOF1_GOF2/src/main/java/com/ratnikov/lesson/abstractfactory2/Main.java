package com.ratnikov.lesson.abstractfactory2;

import com.ratnikov.lesson.abstractfactory2.factories.HouseFactory;
import com.ratnikov.lesson.abstractfactory2.factories.StoneHouseFactory;
import com.ratnikov.lesson.abstractfactory2.factories.WoodHouseFactory;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        HouseFactory factory;
        if (Locale.getDefault().getCountry().equals("RU"))
            factory = new StoneHouseFactory();
        else
            factory = new WoodHouseFactory();

        factory.createWall().build();
        factory.createRoof().cover().waterProtect();
        factory.createWindow().install().open();

    }
}
