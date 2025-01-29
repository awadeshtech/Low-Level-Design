package com.lld.designproject.messaging_queue_pub_sub.interfaces;

import com.lld.designproject.messaging_queue_pub_sub.model.Message;
import com.lld.designproject.messaging_queue_pub_sub.model.Topic;

public interface TopicHandler {
    void publish(Message message);
    Topic getTopic();
}
