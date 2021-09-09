package com.ratnikov.classloader;

import com.ratnikov.classloader.plugins.Plugin;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader {
    public static File[] jars;
    public static Class[] pluginClasses;

    public void createJar() {
        File pluginDir = new File("C:\\JavaSchoolSber\\lesson7_ClassLoaders\\src\\main\\java\\com\\ratnikov\\classloader\\plugins");

        jars = pluginDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".jar");
            }
        });
    }

    public void initFirstPlugin() {
        pluginClasses = new Class[jars.length];

        for (int i = 0; i < jars.length; i++) {
            try {
                URL jarURL = jars[i].toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
                pluginClasses[i] = classLoader.loadClass("com.ratnikov.classloader.plugins.FirstPlugin.ExamplePlugin");
            } catch (MalformedURLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void initSecondPlugin() {
        pluginClasses = new Class[jars.length];

        for (int i = 0; i < jars.length; i++) {
            try {
                URL jarURL = jars[i].toURI().toURL();
                URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
                pluginClasses[i] = classLoader.loadClass("com.ratnikov.classloader.plugins.SecondPlugin.ExamplePlugin");
            } catch (MalformedURLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void startPlugins() {
        for (Class clazz : pluginClasses) {
            try {
                Plugin instance = (Plugin) clazz.newInstance();
                instance.doUsefull();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
