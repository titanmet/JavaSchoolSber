package com.ratnikov.lesson.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void download(String file) {
        strategy.download(file);
    }
}
