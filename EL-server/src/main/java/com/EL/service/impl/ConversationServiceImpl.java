// src/main/java/com/example/demo/service/impl/ConversationServiceImpl.java

package com.EL.service.impl;

import com.EL.context.BaseContext;
import com.EL.entity.Conversation;
import com.EL.mapper.ConversationMapper;
import com.EL.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

    private final ConversationMapper conversationMapper;

    @Autowired
    public ConversationServiceImpl(ConversationMapper conversationMapper) {
        this.conversationMapper = conversationMapper;
    }

    @Override
    public Long getOrCreateConversation(Long participantId) {
        Long commonConversation = conversationMapper.findConversationBetweenUsers(participantId, BaseContext.getCurrentId());
        if (commonConversation == null) {
            List<Long> participantsId = Arrays.asList(participantId, BaseContext.getCurrentId());
            Conversation conversation = new Conversation();
            conversation.setIsGroup(false);
            conversation.setLastMessage("");
            conversation.setLastMessageTimestamp(LocalDateTime.now());
            conversationMapper.insertConversation(conversation);
            conversationMapper.insertParticipants(conversation.getId(), participantsId);
            return conversation.getId();
        }else{
            return commonConversation;
        }

    }

    @Override
    public List<Conversation> getUserConversations(Long userId) {
        return conversationMapper.getConversationsByUserId(userId);
    }

    @Override
    public List<Long> getParticipantIds(Long conversationId) {
        return conversationMapper.getParticipantIds(conversationId);
    }
}
