package com.lld.designproject.messaging_queue_pub_sub.interfaces;

import com.lld.designproject.messaging_queue_pub_sub.model.Message;

public interface Subscriber {
    void consume(Message message);
}
