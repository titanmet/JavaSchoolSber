package com.ratnikov.lesson.HW;

public interface Calculator {

    @Cache(zip = false)
    Double sum_old(double a, double b);

    Double sum_new(double a, double b);
}
