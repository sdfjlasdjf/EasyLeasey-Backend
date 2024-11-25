package com.EL.service;



import com.EL.entity.Conversation;

import java.util.List;

public interface ConversationService {
    Long getOrCreateConversation(Long participantId);
    List<Conversation> getUserConversations(Long userId);
    List<Long> getParticipantIds(Long conversationId);
}
