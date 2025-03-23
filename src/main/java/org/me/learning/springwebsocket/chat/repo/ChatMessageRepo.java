package org.me.learning.springwebsocket.chat.repo;

import org.me.learning.springwebsocket.chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatMessageRepo extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findChatById(String chatId);
}
