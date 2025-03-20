package org.me.learning.springwebsocket.chat.service;


import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chat.model.ChatMessage;
import org.me.learning.springwebsocket.chat.repo.ChatMessageRepo;
import org.me.learning.springwebsocket.chatroom.service.ChatroomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageService {

    private  final ChatMessageRepo chatMessageRepo ;
    private  final ChatroomService chatroomService ;


    public ChatMessage save (ChatMessage chatMessage){
        //!    for creating a chatroom
        var chatId = chatroomService.getChatroomById(chatMessage.getSenderId(), chatMessage.getRecipientId() , true).orElseThrow();//i can throw my exception
        chatMessage.setChatId(chatId);
       return chatMessageRepo.save(chatMessage);
    }

    public List <ChatMessage > findChatMessage (String senderId , String recipientId){
        //!    for finding  a chatroom

        var chatId = chatroomService.getChatroomById(senderId , recipientId , false);
        return chatId.map(chatMessageRepo::findChatbyId).orElse(new ArrayList<>());
    }

}
