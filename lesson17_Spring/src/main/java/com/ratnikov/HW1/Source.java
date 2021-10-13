package com.ratnikov.HW1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Source {
    List<Integer> getFibonachi(int n);

    void saveFibonachi(List<Integer> list);
}
