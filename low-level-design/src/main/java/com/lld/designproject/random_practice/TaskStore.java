package com.lld.designproject.random_practice;

public interface TaskStore <T extends  ScheduleTask>{

    T peek();
    T poll();
    void add(T task);

    void remove(T task);
    boolean isEmpty();
}
