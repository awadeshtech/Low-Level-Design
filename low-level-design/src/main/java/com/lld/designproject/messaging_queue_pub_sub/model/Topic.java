package com.lld.designproject.messaging_queue_pub_sub.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Topic {
    String topicName;
    String topicId;
    List<TopicSubscriber> topicSubscribers;
    List<Message> messages;
}
