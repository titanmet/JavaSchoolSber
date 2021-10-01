package com.ratnikov.lesson.HW;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentCacheProxyImpl implements InvocationHandler {
    private Map<Key, Object> cacheMap = new ConcurrentHashMap<>();
    private Map<Key, Lock> lockMap = new ConcurrentHashMap<>();
    private Object obj;
    private CacheType cacheType;
    private String rootDir;

    public ConcurrentCacheProxyImpl(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new ConcurrentCacheProxyImpl(obj));
    }

    public ConcurrentCacheProxyImpl(Object obj, CacheType cacheType, String rootDir) {
        this.obj = obj;
        this.cacheType = cacheType;
        this.rootDir = rootDir;
        if (this.cacheType == CacheType.MEMORY)
            deserializeCacheMap();
    }

    private void deserializeCacheMap() {
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

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value = null;
        if (method.isAnnotationPresent(Cache.class)) {
            if (this.cacheType == CacheType.MEMORY) {
                Key key = new Key(method.getName(), args);
                value = cacheMap.get(key);
                if (value == null) {
                    value = method.invoke(obj, args);
                    cacheMap.put(key, value);
                    serializeCacheMap();
                }
            }
        } else {
            value = method.invoke(obj, args);
            System.err.println("Метод: " + method.getName() + " с аргументами : " + Arrays.asList(args) + " не кешировался. " + value);
        }

        final Key key = new Key(method.getName(), args);

        Lock lock;
        synchronized (this) {
            if (lockMap.containsKey(key)) {
                lock = lockMap.get(key);
            } else {
                lock = new ReentrantLock();
                lockMap.put(key, lock);
            }
        }

        lock.lock();
        System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " LOCK ");

        value = cacheMap.get(key);
        if (value == null) {
            value = method.invoke(obj, args);
            cacheMap.put(key, value);
            System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " cached result ");
        } else {
            System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " the result obtained from the cache ");

        }
        lock.unlock();
        System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " UNLOCK ");

        return value;
    }

    private void serializeCacheMap() throws IOException {
        try(FileOutputStream fos = new FileOutputStream(rootDir); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for(Key key : cacheMap.keySet()) {
                oos.writeObject(key);
                oos.writeObject(cacheMap.get(key));
            }
            oos.flush();
            oos.close();
        }
    }
}
