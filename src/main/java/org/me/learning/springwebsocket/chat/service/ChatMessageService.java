package org.me.learning.springwebsocket.chat.service;


import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.chat.repo.ChatMessageRepo;
import org.me.learning.springwebsocket.chatroom.service.ChatroomService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatMessageService {

    private  final ChatMessageRepo chatMessageRepo ;
    private  final ChatroomService chatroomService ;

//    need to continue

}
