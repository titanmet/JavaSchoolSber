package com.ratnikov.lesson.abstractfactory2.factories;

import com.ratnikov.lesson.abstractfactory2.roofs.Roof;
import com.ratnikov.lesson.abstractfactory2.roofs.WoodRoof;
import com.ratnikov.lesson.abstractfactory2.walls.Wall;
import com.ratnikov.lesson.abstractfactory2.walls.WoodWall;
import com.ratnikov.lesson.abstractfactory2.windows.Window;
import com.ratnikov.lesson.abstractfactory2.windows.WoodFrameWindow;

public class WoodHouseFactory implements HouseFactory {
    @Override
    public Wall createWall() {
        return new WoodWall();
    }

    @Override
    public Roof createRoof() {
        return new WoodRoof();
    }

    @Override
    public Window createWindow() {
        return new WoodFrameWindow();
    }

}
