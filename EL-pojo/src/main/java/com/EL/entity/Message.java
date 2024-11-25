package com.EL.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data

public class Message {
    private Long id;
    private Long senderId;
    private Long conversationId;
    private String content;
    private LocalDateTime timestamp;


}
