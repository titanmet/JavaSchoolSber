package com.ratnikov.executionmanager;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutionManagerImpl implements ExecutionManager {
    private final AtomicInteger completedTaskCount = new AtomicInteger();
    private final AtomicInteger failedTaskCount = new AtomicInteger();
    private final AtomicInteger interruptedTaskCount = new AtomicInteger();
    private final AtomicInteger interruptedTask = new AtomicInteger();
    private final AtomicBoolean finishedTask = new AtomicBoolean(false);
    private ExecutorService executorService;

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        executorService = Executors.newFixedThreadPool(10);
        Arrays.stream(tasks).map(t -> {
                    return (Runnable) () -> {
                        if (finishedTask.get()) {
                            interruptedTaskCount.incrementAndGet();
                        } else {
                            t.run();
                            completedTaskCount.incrementAndGet();
                        }
                        if (interruptedTask.incrementAndGet() == tasks.length) {
                            callback.run();
                            executorService.shutdown();
                        }
                    };
                }
        ).forEach(executorService::submit);

        return new ContextImpl();
    }


    private class ContextImpl implements Context {

        @Override
        public int getCompletedTaskCount() {
            return completedTaskCount.get();
        }

        @Override
        public int getFailedTaskCount() {
            return failedTaskCount.get();
        }

        @Override
        public int getInterruptedTaskCount() {
            return interruptedTaskCount.get();
        }

        @Override
        public void interrupt() {
            finishedTask.set(true);
        }

        @Override
        public boolean isFinished() {
            return executorService.isShutdown();
        }
    }
}
