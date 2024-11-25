// src/main/java/com/example/demo/entity/Conversation.java

package com.EL.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Conversation {
    private Long id;
    private String lastMessage;
    private LocalDateTime lastMessageTimestamp;
    private Boolean isGroup;
    private List<Long> participantIds;


}
