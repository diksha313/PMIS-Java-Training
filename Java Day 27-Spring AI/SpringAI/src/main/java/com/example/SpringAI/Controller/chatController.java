package com.example.SpringAI.Controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api")
public class chatController {
    private final ChatClient chatClient;
    public chatController(ChatClient.Builder builder)
    {
        this.chatClient=builder.build();
    }
    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam("q") String q) {

        String response = chatClient.prompt()
                .user(q)
                .call()
                .content();

        System.out.println("Gemini Response: " + response);
        return ResponseEntity.ok(response);
    }

}
