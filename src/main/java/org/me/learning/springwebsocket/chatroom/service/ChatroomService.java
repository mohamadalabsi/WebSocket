package org.me.learning.springwebsocket.chatroom.service;



import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chatroom.model.ChatRoom;
import org.me.learning.springwebsocket.chatroom.repo.ChatroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ChatroomService {
    @Autowired
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

//        ChatRoom senderRecipient = ChatRoom.builder()
//                .chatId(chatId)
//                .senderId(senderId)
//                .recipientId(recipientId)
//                .build();
        ChatRoom senderRecipient = new ChatRoom();  // No-args constructor
        senderRecipient.setChatId(chatId);
        senderRecipient.setSenderId(senderId);
        senderRecipient.setRecipientId(recipientId);



//        ChatRoom recipientSender = ChatRoom.builder()
//                .chatId(chatId)
//                .senderId(recipientId)
//                .recipientId(senderId)
//                .build();

        ChatRoom recipientSender = new ChatRoom();  // No-args constructor
        recipientSender.setChatId(chatId);
        recipientSender.setSenderId(recipientId);
        recipientSender.setRecipientId(senderId);


        chatroomRepo.save(senderRecipient);
        chatroomRepo.save(recipientSender);

        return chatId ;


    }
}
