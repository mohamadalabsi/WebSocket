package org.me.learning.springwebsocket.chatroom.repo;


import org.me.learning.springwebsocket.chatroom.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatroomRepo extends MongoRepository<ChatRoom , String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
