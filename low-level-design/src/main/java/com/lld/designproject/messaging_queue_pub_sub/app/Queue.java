package com.lld.designproject.messaging_queue_pub_sub.app;

import com.lld.designproject.messaging_queue_pub_sub.interfaces.TopicHandler;
import com.lld.designproject.messaging_queue_pub_sub.interfaces.TopicHandlerImpl;
import com.lld.designproject.messaging_queue_pub_sub.model.Message;
import com.lld.designproject.messaging_queue_pub_sub.model.Topic;
import com.lld.designproject.messaging_queue_pub_sub.model.TopicSubscriber;
import java.util.ArrayList;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Queue {
    Map<String, TopicHandler> topicToSubscriberMap;

    public void publishMessage(String topicId, Message message) {
        topicToSubscriberMap.get(topicId).publish(message);
    }

    public void createTopic(String topicName, String topicId) {
        Topic topic = new Topic(topicName, topicId, new ArrayList<>(), new ArrayList<>());
        TopicHandler topicHandler = new TopicHandlerImpl(topic);
        topicToSubscriberMap.put(topicId, topicHandler);
    }

    public void subscribeTopic(String topicId, TopicSubscriber topicSubscriber) {
        Topic topic = topicToSubscriberMap.get(topicId).getTopic();
        topic.getTopicSubscribers().add(topicSubscriber);
    }
}
