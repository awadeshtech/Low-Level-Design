package com.lld.designproject.random_practice;

public abstract class ScheduleTask {
    public final ExecutionContext executionContext;

    public ScheduleTask(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    abstract boolean isRecurring();
    abstract long nextExecutionTime();

    public void execute(){
        executionContext.execute();
    }



}
