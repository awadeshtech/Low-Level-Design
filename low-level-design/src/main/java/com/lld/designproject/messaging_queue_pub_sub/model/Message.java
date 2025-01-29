package com.lld.designproject.messaging_queue_pub_sub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Message {
    private String message;
    private String id;
}
