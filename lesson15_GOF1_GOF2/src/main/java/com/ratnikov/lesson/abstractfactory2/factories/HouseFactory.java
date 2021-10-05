package com.ratnikov.lesson.abstractfactory2.factories;

import com.ratnikov.lesson.abstractfactory2.roofs.Roof;
import com.ratnikov.lesson.abstractfactory2.walls.Wall;
import com.ratnikov.lesson.abstractfactory2.windows.Window;

public interface HouseFactory {
    Wall createWall();
    Roof createRoof();
    Window createWindow();
}
