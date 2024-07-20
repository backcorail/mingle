package com.project.mingle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.project.mingle.service.ChatService;
import com.project.mingle.vo.ChatVO;

@Controller
public class MessageController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatVO sendMessage(ChatVO message) throws Exception {
        // 메시지를 데이터베이스에 저장
        chatService.saveMessage(message);
        return message;
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    // AJAX를 통해 저장된 메시지를 불러오는 엔드포인트
    @GetMapping("/load-messages")
    @ResponseBody
    public List<ChatVO> loadMessages() {
        // 저장된 모든 메시지를 불러옴
        return chatService.chatList();
    }
}
