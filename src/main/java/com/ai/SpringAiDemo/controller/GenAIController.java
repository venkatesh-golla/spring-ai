package com.ai.SpringAiDemo.controller;

import com.ai.SpringAiDemo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenAIController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("/chat-options")
    public String getResponseWithOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }
}
