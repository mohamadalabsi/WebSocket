package org.me.learning.springwebsocket.chat.controller;


import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chat.service.ChatMessageService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final ChatMessageService chatMessageService ;

    
}
