package com.olimpo.messenger.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.olimpo.messenger.model.Message;

@Controller
public class ChatController {
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    private Message register(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender()); 
        return message;
    }
    
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    private Message sendMessage(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        return message;
    }

}
