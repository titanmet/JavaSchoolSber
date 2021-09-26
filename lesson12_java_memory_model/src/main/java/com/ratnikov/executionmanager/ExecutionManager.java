package com.ratnikov.executionmanager;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
