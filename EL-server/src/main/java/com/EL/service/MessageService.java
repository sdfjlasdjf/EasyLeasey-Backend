// src/main/java/com/example/demo/service/MessageService.java

package com.EL.service;

import com.EL.entity.Message;

import java.util.List;

public interface MessageService {
    void saveMessage(Message message);
    List<Message> getMessagesByConversationId(Long conversationId);
}
