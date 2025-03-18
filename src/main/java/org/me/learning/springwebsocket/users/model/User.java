package org.me.learning.springwebsocket.users.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// another way to use lombok
@Getter
@Setter
@Document
public class User {

    @Id
    private String nickName;
    private String  fullName;
    private Status status ;
}
