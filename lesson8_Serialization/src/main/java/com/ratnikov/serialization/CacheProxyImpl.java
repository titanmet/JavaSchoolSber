package com.ratnikov.serialization;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxyImpl implements InvocationHandler {
    private Map<Key, Object> cacheMap = new HashMap<>();
    private Object obj;
    private CacheType cacheType;
    private String rootDir;


    public static Object newInstance(Object obj, CacheType cacheType, String rootDir) throws IOException, ClassNotFoundException {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new CacheProxyImpl(obj, cacheType, rootDir));
    }

    private CacheProxyImpl(Object obj, CacheType cacheType, String rootDir) throws IOException, ClassNotFoundException {
        this.obj = obj;
        this.cacheType = cacheType;
        this.rootDir = rootDir;
        if (this.cacheType == CacheType.MEMORY)
            deserializeCacheMap();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;
        if (method.isAnnotationPresent(Cache.class)) {
            switch (this.cacheType) {
                case MEMORY:
                    Key key = new Key(method.getName(), args);
                    value = cacheMap.get(key);
                    if (value == null) {
                        value = method.invoke(obj, args);
                        cacheMap.put(key, value);
                        serializeCacheMap();
                    }
                    break;
            }
        } else {
            value = method.invoke(obj, args);
            System.err.println("Метод: " + "'" + method.getName() + "'" + " с аргументами : " + Arrays.asList(args) + " не кешировался." + value);
        }
        return value;
    }

    private void serializeCacheMap() throws IOException {

        try (FileOutputStream fos = new FileOutputStream(rootDir);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Key key : cacheMap.keySet()) {
                oos.writeObject(key);
                oos.writeObject(cacheMap.get(key));
            }
            oos.flush();
            oos.close();
        }
    }

    private void deserializeCacheMap() throws IOException, ClassNotFoundException {
        File[] files = new File(this.rootDir).listFiles();
        for (File file : files) {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                Key key = (Key) ois.readObject();
                Object value = ois.readObject();
                cacheMap.put(key, value);
            } catch (Exception e) {
                System.out.println("Ignored");
            }
        }
    }
}
