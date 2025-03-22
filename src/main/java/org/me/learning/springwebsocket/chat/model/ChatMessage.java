package org.me.learning.springwebsocket.chat.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document (collection = "ChatMessage")
public class ChatMessage {

    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String content ;
    private Date Timestamp;
//
//    @Builder
//    public ChatMessage(String id, String chatId, String senderId, String recipientId, String content, Date timestamp) {
//        this.id = id;
//        this.chatId = chatId;
//        this.senderId = senderId;
//        this.recipientId = recipientId;
//        this.content = content;
//        Timestamp = timestamp;
//    }
//
//    public ChatMessage() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getChatId() {
//        return chatId;
//    }
//
//    public void setChatId(String chatId) {
//        this.chatId = chatId;
//    }
//
//    public String getRecipientId() {
//        return recipientId;
//    }
//
//    public void setRecipientId(String recipientId) {
//        this.recipientId = recipientId;
//    }
//
//    public String getSenderId() {
//        return senderId;
//    }
//
//    public void setSenderId(String senderId) {
//        this.senderId = senderId;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getTimestamp() {
//        return Timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        Timestamp = timestamp;
//    }
}
