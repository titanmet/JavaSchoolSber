package com.ratnikov.lesson.State;

public class StopPlay implements State {
    @Override
    public void doAction() {
        System.out.println("Stop play");
    }
}
