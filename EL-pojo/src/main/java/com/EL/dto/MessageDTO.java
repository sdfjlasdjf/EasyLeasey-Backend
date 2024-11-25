package com.EL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {
    private String content;
    private Long senderId;
    private MessageType type;
    private Long conversationId;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    // Constructors, getters, and setters
    // ...
}