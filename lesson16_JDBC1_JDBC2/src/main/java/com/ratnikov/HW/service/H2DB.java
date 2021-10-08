package com.ratnikov.HW.service;

import com.ratnikov.HW.Source;
import com.ratnikov.HW.dao.FibonachiDaoImpl;

import java.util.List;

public class H2DB implements Source {
    FibonachiDaoImpl fibonachiDao;
    @Override
    public List<Integer> getFibonachi(int n) {
        if(fibonachiDao == null) {
            fibonachiDao = new FibonachiDaoImpl();
        }
        List<Integer> list = fibonachiDao.getFibonachi(n);
        return list;
    }

    @Override
    public void saveFibonachi(List<Integer> list) {
        if(fibonachiDao == null) {
            fibonachiDao = new FibonachiDaoImpl();
        }
        fibonachiDao.createFibonachi(list);
    }
}
