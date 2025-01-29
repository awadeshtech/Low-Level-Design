package com.lld.designproject.messaging_queue_pub_sub;

import com.lld.designproject.messaging_queue_pub_sub.app.Queue;
import com.lld.designproject.messaging_queue_pub_sub.interfaces.DefaultSubscriberImpl;
import com.lld.designproject.messaging_queue_pub_sub.interfaces.Subscriber;
import com.lld.designproject.messaging_queue_pub_sub.model.Message;
import com.lld.designproject.messaging_queue_pub_sub.model.TopicSubscriber;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Orchestrator {
    public static void main(String[] args) {
        Queue queue = new Queue(new HashMap<>());
        queue.createTopic("testTopic", "123");
        Subscriber subscriber = new DefaultSubscriberImpl();
        TopicSubscriber topicSubscriber = new TopicSubscriber("subscriber1", new AtomicInteger(0), subscriber);
        queue.subscribeTopic("123", topicSubscriber);
        Message message = new Message("First Message", "1");
        queue.publishMessage("123", message);
    }
}
