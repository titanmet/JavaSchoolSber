package com.ratnikov.serialization;

import java.util.Date;
import java.util.List;

import static com.ratnikov.serialization.CacheType.FILE;
import static com.ratnikov.serialization.CacheType.MEMORY;


public interface Service {
    @Cache(zip = false, cacheType = FILE)
    double doHardWork(String item, double value, Date date);

    @Cache(cacheType = FILE, zip = true)
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = FILE, listList = 10_000, zip = false)
    List<String> work(String item);

    @Cache(cacheType = MEMORY, zip = false)
    double calc(double n, double n1);
}
