package com.ratnikov.lesson.Bridge;

public class UnknownEngine implements Engine{
    @Override
    public void setEngine() {
        System.out.println("Unknown");
    }
}
