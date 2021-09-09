package com.ratnikov.classloader;

import com.ratnikov.classloader.plugins.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final String pluginRootDirectory = "C:\\JavaSchoolSber\\lesson7_ClassLoaders\\src\\main\\java\\com\\ratnikov\\classloader\\plugins\\FirstPlugin";
        PluginManager pluginManager = new PluginManager(pluginRootDirectory);
        System.out.println("init");
        pluginManager.init();
        pluginManager.start();


        PluginClassLoader pluginClassLoader = new PluginClassLoader();
        pluginClassLoader.createJar();
        pluginClassLoader.initFirstPlugin();
        pluginClassLoader.startPlugins();
        pluginClassLoader.initSecondPlugin();
        pluginClassLoader.startPlugins();
    }
}
