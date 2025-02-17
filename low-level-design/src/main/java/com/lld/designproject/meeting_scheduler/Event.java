package com.lld.designproject.meeting_scheduler;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Event {
    String title;
    int id;
    long startTime;
    long endTime;
    List<User> participants;
    Notifier notifier;
}
