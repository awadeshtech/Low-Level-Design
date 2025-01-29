package com.lld.designproject.messaging_queue_pub_sub.interfaces;

import com.lld.designproject.messaging_queue_pub_sub.model.Message;

public class DefaultSubscriberImpl implements Subscriber {
    @Override
    public void consume(Message message) {
        System.out.println("Consumed message: " + message.getMessage());
    }
}
