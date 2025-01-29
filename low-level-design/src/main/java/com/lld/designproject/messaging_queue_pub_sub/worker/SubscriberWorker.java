package com.lld.designproject.messaging_queue_pub_sub.worker;

import com.lld.designproject.messaging_queue_pub_sub.model.Topic;
import com.lld.designproject.messaging_queue_pub_sub.model.TopicSubscriber;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class SubscriberWorker implements Runnable {
    private Topic topic;
    private TopicSubscriber topicSubscriber;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            while (true) {
                if (topic.getMessages().size() > topicSubscriber.getOffset().get()) {
                    topicSubscriber.getSubscriber().consume(topic.getMessages().get(topicSubscriber.getOffset().get()));
                    topicSubscriber.getOffset()
                        .compareAndSet(topicSubscriber.getOffset().get(), topicSubscriber.getOffset().get() + 1);
                } else {
                    topicSubscriber.wait();
                }
            }
        }
    }
}
