package com.ratnikov.HW1.dao;

import java.util.List;

public interface FibonachiDao {
    void createFibonachi(List<Integer> list);

    List<Integer> getFibonachi(int n);

    void predestroyFibonachi();
}
