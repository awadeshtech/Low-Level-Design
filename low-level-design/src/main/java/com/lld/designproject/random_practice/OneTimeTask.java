package com.lld.designproject.random_practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class OneTimeTask extends ScheduleTask {
    private final long executionTime;

    public OneTimeTask(ExecutionContext executionContext, long executionTime) {
        super(executionContext);
        this.executionTime = executionTime;
    }

    @Override
    boolean isRecurring() {
//        ConcurrentLinkedDeque
        return false;
    }

    @Override
    long nextExecutionTime() {
        return executionTime;
    }
}
