package com.ratnikov.lesson.abstractfactory2.factories;

import com.ratnikov.lesson.abstractfactory2.roofs.Roof;
import com.ratnikov.lesson.abstractfactory2.roofs.TileRoof;
import com.ratnikov.lesson.abstractfactory2.walls.BrickWall;
import com.ratnikov.lesson.abstractfactory2.walls.Wall;
import com.ratnikov.lesson.abstractfactory2.windows.PlasticFrameWindow;
import com.ratnikov.lesson.abstractfactory2.windows.Window;

public class StoneHouseFactory implements HouseFactory {
    @Override
    public Wall createWall() {
        return new BrickWall();
    }

    @Override
    public Roof createRoof() {
        return new TileRoof();
    }

    @Override
    public Window createWindow() {
        return new PlasticFrameWindow();
    }
}
