package com.lld.designproject.messaging_queue_pub_sub.interfaces;

import com.lld.designproject.messaging_queue_pub_sub.model.Message;
import com.lld.designproject.messaging_queue_pub_sub.model.Topic;
import com.lld.designproject.messaging_queue_pub_sub.model.TopicSubscriber;
import com.lld.designproject.messaging_queue_pub_sub.worker.SubscriberWorker;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class TopicHandlerImpl implements TopicHandler {
    private final Topic topic;
    private Map<String, SubscriberWorker> subscriberToWorkerMap;// id of the subscriber to worker mapping

    public TopicHandlerImpl(Topic topic) {
        this.topic = topic;
        this.subscriberToWorkerMap = new HashMap<>();
    }

    @Override
    public void publish(Message message) {
        topic.getMessages().add(message);
        // topic.getTopicSubscribers().forEach(subscriber -> subscriber.getSubscriber().consume(message));
        for (TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            if (!subscriberToWorkerMap.containsKey(topicSubscriber.getId())) {
                SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
                Thread thread = new Thread(subscriberWorker);
                subscriberToWorkerMap.put(topicSubscriber.getId(), subscriberWorker);
                thread.start();
            } else {
                topicSubscriber.notify();
            }
        }

    }


}
