package com.ratnikov.classloader.plugins.FirstPlugin;

import com.ratnikov.classloader.plugins.Plugin;

public class ExamplePlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Hello !!! The first Example Plugin !");
    }
}
