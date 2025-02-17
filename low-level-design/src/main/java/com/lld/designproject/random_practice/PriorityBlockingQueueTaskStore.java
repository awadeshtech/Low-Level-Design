package com.lld.designproject.random_practice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import org.springframework.scheduling.config.ScheduledTask;

public class PriorityBlockingQueueTaskStore implements TaskStore<ScheduleTask>{


    private final PriorityBlockingQueue<ScheduledTask> taskQueue;

    private final Set<ScheduledTask> tasks;

    public PriorityBlockingQueueTaskStore(Comparator<ScheduledTask> comparator, Integer queueSize) {
        this.taskQueue = new PriorityBlockingQueue<>(queueSize, comparator);
        this.tasks = new HashSet<>();
    }
    @Override
    public ScheduleTask peek() {
        return null;
    }

    @Override
    public ScheduleTask poll() {
        return null;
    }

    @Override
    public void add(ScheduleTask task) {

    }

    @Override
    public void remove(ScheduleTask task) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
