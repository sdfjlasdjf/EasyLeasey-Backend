// src/main/java/com/example/demo/service/impl/MessageServiceImpl.java

package com.EL.service.impl;

import com.EL.entity.Message;
import com.EL.mapper.MessageMapper;
import com.EL.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public void saveMessage(Message message) {
        messageMapper.insertMessage(message);
    }

    @Override
    public List<Message> getMessagesByConversationId(Long conversationId) {
        return messageMapper.getMessagesByConversationId(conversationId);
    }
}
