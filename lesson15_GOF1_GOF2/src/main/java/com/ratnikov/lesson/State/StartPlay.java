package com.ratnikov.lesson.State;

public class StartPlay implements State{
    @Override
    public void doAction() {
        System.out.println("Start Play");
    }
}
