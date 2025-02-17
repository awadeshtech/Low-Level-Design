package com.lld.designproject.messaging_queue_pub_sub.model;

import com.lld.designproject.messaging_queue_pub_sub.interfaces.Subscriber;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopicSubscriber {
    private String id;
    private AtomicInteger offset;
    private Subscriber subscriber;
}
