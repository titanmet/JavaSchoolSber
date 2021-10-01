package com.ratnikov.lesson.concurrent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteMap<String, String> map = new ReadWriteMap(new HashMap());
//        Map<String, String> map = new HashMap<>();
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(()->{
            map.put("key", "value");
        });
        es.submit(()->System.err.println("k,v = 1 "+ map.get("key")));
        Thread.sleep(200);
        es.submit(()->System.err.println("k,v = 2 "+ map.get("key")));
        Thread.sleep(200);
        es.submit(()->System.err.println("k,v = 3 "+ map.get("key")));
        es.shutdown();

    }

    public static class ReadWriteMap<K, V> {
        private final Map<K, V> map;
        private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
        private final Lock r = lock.readLock();
        private final Lock w = lock.writeLock();

        public ReadWriteMap(Map<K, V> map) {
            this.map = map;
        }

        public V put(K key, V value) {
            w.lock();
            try {
                System.err.println(value + " put = " + new Date().getTime());
                TimeUnit.MILLISECONDS.sleep(4000);
                return map.put(key, value);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                w.unlock();
            }
        }

        public V get(Object key) {
            r.lock();
            try {
                System.err.println(key + " get = "+new Date().getTime());
                V v = map.get(key);
                Thread.sleep(1000);
                return v;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                r.unlock();
            }
            return null;
        }
    }
}
