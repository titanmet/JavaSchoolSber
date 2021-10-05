package com.ratnikov.lesson.FactoryMethod;

import com.ratnikov.lesson.FactoryMethod.windows.Window;
import com.ratnikov.lesson.FactoryMethod.windows.WoodFrameWindow;

public class CompanyB extends Supplier{
    @Override
    public Window createWindow() {
        return new WoodFrameWindow();
    }
}
