package com.ratnikov.classloader.plugins.SecondPlugin;

import com.ratnikov.classloader.plugins.Plugin;

public class ExamplePlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println("Hello !!! The second Example Plugin !");
    }
}
