// src/main/java/com/example/demo/mapper/ConversationMapper.java

package com.EL.mapper;

import com.EL.entity.Conversation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ConversationMapper {

    @Insert("INSERT INTO conversations (last_message, last_message_timestamp, is_group) VALUES (#{lastMessage}, #{lastMessageTimestamp}, #{isGroup})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertConversation(Conversation conversation);

    @Select("SELECT c.id FROM conversations c " +
            "JOIN conversation_participants cp1 ON c.id = cp1.conversation_id AND cp1.user_id = #{userId1} " +
            "JOIN conversation_participants cp2 ON c.id = cp2.conversation_id AND cp2.user_id = #{userId2} " +
            "WHERE c.is_group = FALSE " +
            "LIMIT 1"
            )
    Long findConversationBetweenUsers(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    @Insert("<script>" +
            "INSERT INTO conversation_participants (conversation_id, user_id) VALUES " +
            "<foreach collection='participantIds' item='userId' separator=','> (#{conversationId}, #{userId}) </foreach>" +
            "</script>")
    void insertParticipants(@Param("conversationId") Long conversationId, @Param("participantIds") List<Long> participantIds);

    @Select("SELECT c.* FROM conversations c INNER JOIN conversation_participants cp ON c.id = cp.conversation_id WHERE cp.user_id = #{userId}")
    List<Conversation> getConversationsByUserId(@Param("userId") Long userId);

    @Select("SELECT user_id FROM conversation_participants WHERE conversation_id = #{conversationId}")
    List<Long> getParticipantIds(@Param("conversationId") Long conversationId);
}
