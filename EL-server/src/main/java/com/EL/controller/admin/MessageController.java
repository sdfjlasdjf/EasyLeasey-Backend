// src/main/java/com/example/demo/controller/ChatController.java

package com.EL.controller.admin;


import com.EL.context.BaseContext;
import com.EL.dto.MessageDTO;
import com.EL.entity.Message;
import com.EL.result.Result;
import com.EL.service.ConversationService;
import com.EL.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin/chat")
public class MessageController {
    private final MessageService messageService;
    private final ConversationService conversationService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(MessageService messageService, ConversationService conversationService, SimpMessagingTemplate messagingTemplate) {
        this.messageService = messageService;
        this.conversationService = conversationService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage")
    public void handleChatMessage(@Payload MessageDTO chatMessage) {
        Long senderId = BaseContext.getCurrentId();
        chatMessage.setSenderId(senderId);

        // Save message to the database
        Message message = new Message();
        message.setSenderId(senderId);
        message.setConversationId(chatMessage.getConversationId());
        message.setContent(chatMessage.getContent());
        message.setTimestamp(LocalDateTime.now());
        messageService.saveMessage(message);

        // Update conversation's last message
        // Implement update logic in ConversationService if needed

        // Send the message to all participants
        List<Long> participantIds = conversationService.getParticipantIds(chatMessage.getConversationId());
        for (Long participantId : participantIds) {
            messagingTemplate.convertAndSendToUser(
                    String.valueOf(participantId),
                    "/queue/messages",
                    chatMessage
            );
        }
    }

    @GetMapping("/history/{conversationId}")
    @ResponseBody
    public Result<List<Message>> getConversationMessages(@PathVariable Long conversationId, Principal principal) {
        // Optional: Verify that the user is a participant of the conversation
        List<Message> messages = messageService.getMessagesByConversationId(conversationId);
        return Result.success(messages);
    }
}
