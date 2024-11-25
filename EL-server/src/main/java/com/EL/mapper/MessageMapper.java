package com.EL.mapper;


import com.EL.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

// src/main/java/com/example/demo/mapper/MessageMapper.java



@Mapper
public interface MessageMapper {

    @Insert("INSERT INTO message (sender_id, conversation_id, content, timestamp) VALUES (#{senderId}, #{conversationId}, #{content}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertMessage(Message message);

    @Select("SELECT * FROM message WHERE conversation_id = #{conversationId} ORDER BY timestamp")
    List<Message> getMessagesByConversationId(@Param("conversationId") Long conversationId);
}


