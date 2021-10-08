package com.ratnikov.HW.dao;

import java.util.List;
import java.util.Set;

public interface FibonachiDao {
    void createFibonachi(List<Integer> list);
    List<Integer> getFibonachi(int n);
}
