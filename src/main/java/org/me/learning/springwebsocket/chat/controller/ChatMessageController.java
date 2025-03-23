package org.me.learning.springwebsocket.chat.controller;


import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chat.model.ChatMessage;
import org.me.learning.springwebsocket.chat.model.ChatNotification;
import org.me.learning.springwebsocket.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class ChatMessageController {

    @Autowired
    private final ChatMessageService chatMessageService ;
    @Autowired
    private final SimpMessagingTemplate messagingTemplate ;

    public ChatMessageController(ChatMessageService chatMessageService, SimpMessagingTemplate messagingTemplate) {
        this.chatMessageService = chatMessageService;
        this.messagingTemplate = messagingTemplate;
    }


    @MessageMapping ("/chat")
    public void processMessage (@Payload ChatMessage chatMessage ){
        ChatMessage savedMessage = chatMessageService.save(chatMessage);
//        mohammad/queue/messages
        messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId() , "queue/messages" ,
                new ChatNotification(
                        savedMessage.getId(),
                        savedMessage.getSenderId(),
                        savedMessage.getRecipientId(),
                        savedMessage.getContent()
                ));
//       ChatNotification.builder().id(savedMessage.getId()).senderId(savedMessage.getSenderId()).recipientId(savedMessage.getRecipientId()).content(savedMessage.getContent()).build());
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity <List<ChatMessage>> findChatMessages(@PathVariable("senderId") String senderId,@PathVariable("recipientId") String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessage(senderId,recipientId));
    }



}
