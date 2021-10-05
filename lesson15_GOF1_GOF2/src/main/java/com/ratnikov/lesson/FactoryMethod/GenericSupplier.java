package com.ratnikov.lesson.FactoryMethod;

import com.ratnikov.lesson.FactoryMethod.windows.Window;

public class GenericSupplier extends Supplier {
    private Class<? extends Window> windowType;

    public GenericSupplier(Class<? extends Window> windowType) {
        this.windowType = windowType;
    }

    @Override
    public Window createWindow() {
        try {
            return windowType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return super.createWindow();
        }
    }
}
