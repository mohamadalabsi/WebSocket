package org.me.learning.springwebsocket.users.controller;


import lombok.RequiredArgsConstructor;
import org.me.learning.springwebsocket.users.model.User;
import org.me.learning.springwebsocket.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor // instead of autowiring manually
public class UserController {

    @Autowired
    private UserService userService;

// !    second thing to notice
    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public User addUser (@Payload User user ){
        userService.saveUser(user);
        return user ;

    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public User disconnectUser (@Payload User user ){
        userService.disconnect(user);
        return user ;

    }

    @GetMapping("/users")
    public ResponseEntity <List<User>> findConnectedUsers(){
        return  ResponseEntity.ok(userService.findConnectedUsers());
    }



}
