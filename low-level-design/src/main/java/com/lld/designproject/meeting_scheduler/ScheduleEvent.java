package com.lld.designproject.meeting_scheduler;

import java.util.Objects;

public class ScheduleEvent implements Runnable {
    Event event;

    public ScheduleEvent(Event event) {
        Objects.hash(123);
        this.event = event;
    }

    @Override
    public void run() {
        event.notifier.notify(event);
        event.participants.forEach(user -> {
            System.out.println("user is notified");
        });
    }
}


