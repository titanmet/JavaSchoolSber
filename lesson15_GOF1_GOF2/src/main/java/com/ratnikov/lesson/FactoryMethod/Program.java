package com.ratnikov.lesson.FactoryMethod;

import com.ratnikov.lesson.FactoryMethod.windows.MetalFrameWindow;
import com.ratnikov.lesson.FactoryMethod.windows.Window;

import java.util.ArrayList;
import java.util.List;

public class Program {
    static List<Window> windows = new ArrayList<Window>();

    public static void main(String[] args) {
        Supplier[] creators = new Supplier[] {
                new Supplier(), new CompanyA(), new CompanyB(),
                new GenericSupplier(MetalFrameWindow.class)};

        for(Supplier c : creators)
            c.install().open();

        System.out.println("Установленные окна:");
        for(Window w : windows)
            System.out.println(w);
    }
}
