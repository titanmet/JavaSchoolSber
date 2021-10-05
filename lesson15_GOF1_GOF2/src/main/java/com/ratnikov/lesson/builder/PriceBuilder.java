package com.ratnikov.lesson.builder;

public class PriceBuilder implements Builder {
    private int total;

    @Override
    public void reset() {
        total = 0;

    }

    @Override
    public void perpare() {
        total += 500;

    }

    @Override
    public void mainWork() {
        total += 1500;

    }

    @Override
    public void addServiceLines() {
        total += 300;

    }

    @Override
    public void finsish() {
        total += 400;

    }

    public int getResult() {
        return total;
    }
}
