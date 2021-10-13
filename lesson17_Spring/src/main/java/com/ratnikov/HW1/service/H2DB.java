package com.ratnikov.HW1.service;

import com.ratnikov.HW1.Source;
import com.ratnikov.HW1.dao.FibonachiDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class H2DB implements Source {
    FibonachiDaoImpl fibonachiDao;

    //    @Autowired
    public H2DB(FibonachiDaoImpl fibonachiDao) {
        this.fibonachiDao = fibonachiDao;
    }

    @Override
    public List<Integer> getFibonachi(int n) {
        if (fibonachiDao == null) {
            fibonachiDao = new FibonachiDaoImpl();
        }
        List<Integer> list = fibonachiDao.getFibonachi(n);
        return list;
    }

    @Override
    public void saveFibonachi(List<Integer> list) {
        if (fibonachiDao == null) {
            fibonachiDao = new FibonachiDaoImpl();
        }
        fibonachiDao.createFibonachi(list);
    }
}
