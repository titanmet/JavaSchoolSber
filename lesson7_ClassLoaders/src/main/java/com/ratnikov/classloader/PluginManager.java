package com.ratnikov.classloader;

import com.ratnikov.classloader.plugins.Plugin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PluginManager {
    private final File pluginRootDirectory;
    private final List<Plugin> plugins = new LinkedList<>();
    private final ClassLoader loader;

    public PluginManager(String pluginRootDirectory) throws MalformedURLException {
        File rootDir = new File(pluginRootDirectory);
        if(!rootDir.isDirectory()){
            throw new IllegalArgumentException();
        }
        this.pluginRootDirectory = rootDir;
        File file = new File(rootDir+"");
        loader = new URLClassLoader(new URL[]{file.toURI().toURL()});

    }

    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            return (Plugin) loader.loadClass(pluginClassName).getConstructor().newInstance();
    }

    public void init() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<File> allPlugins = getAllPath();
        for (File file : allPlugins) {
            String pluginName = file.getName();
            plugins.add(load(pluginName, pluginName));
        }
    }

    public void start(){
        for (Plugin plugin : plugins) {
            plugin.doUsefull();
        }
    }

    private List<File> getAllPath() {
        File[] files = pluginRootDirectory.listFiles();
        assert files != null;
        return Arrays.stream(files).filter(File::isDirectory).collect(Collectors.toList());
    }

}
