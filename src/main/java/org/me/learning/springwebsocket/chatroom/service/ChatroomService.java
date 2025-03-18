package org.me.learning.springwebsocket.chatroom.service;



import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chatroom.model.ChatRoom;
import org.me.learning.springwebsocket.chatroom.repo.ChatroomRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatroomService {

    private ChatroomRepo chatroomRepo ;


    public Optional<String> getChatroomById(String senderId, String recipientId , boolean createChatroomIfNotExist){

        return chatroomRepo.findBySenderIdAndRecipientId(senderId , recipientId)
                .map(ChatRoom::getChatId)
                .or(()->
                {
                    if (createChatroomIfNotExist){
                        var chatId =createChatId(senderId , recipientId);
                        return Optional.of(chatId);
                    }
                        return Optional.empty();

                });

    }

    private String createChatId(String senderId, String recipientId) {
        var chatId = String.format("%s_%s", senderId,recipientId);  // mohammad_malek

        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();
        chatroomRepo.save(senderRecipient);
        chatroomRepo.save(recipientSender);

        return chatId ;


    }
}
