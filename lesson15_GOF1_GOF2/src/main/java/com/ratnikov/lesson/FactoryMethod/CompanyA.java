package com.ratnikov.lesson.FactoryMethod;

import com.ratnikov.lesson.FactoryMethod.windows.PlasticFrameWindow;
import com.ratnikov.lesson.FactoryMethod.windows.Window;

public class CompanyA extends Supplier {
    @Override
    public Window createWindow() {
        return new PlasticFrameWindow();
    }
}
