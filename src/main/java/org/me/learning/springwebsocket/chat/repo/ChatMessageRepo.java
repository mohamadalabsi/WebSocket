package org.me.learning.springwebsocket.chat.repo;

import org.me.learning.springwebsocket.chat.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChatMessageRepo extends MongoRepository<ChatMessage, String> {
}
