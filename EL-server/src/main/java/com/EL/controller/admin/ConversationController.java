// src/main/java/com/example/demo/controller/ConversationController.java

package com.EL.controller.admin;

import com.EL.context.BaseContext;
import com.EL.entity.Conversation;
import com.EL.result.Result;
import com.EL.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/admin/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("/list")
    public Result<List<Conversation>> getUserConversations() {
        Long userId = BaseContext.getCurrentId();
        List<Conversation> conversations = conversationService.getUserConversations(userId);
        return Result.success(conversations);
    }

    @PostMapping("/getorcreate")
    public Result<Long> getOrCreateConversation(Long participantId) {
        Long conversationId = conversationService.getOrCreateConversation(participantId);
        return Result.success(conversationId);
    }

}
