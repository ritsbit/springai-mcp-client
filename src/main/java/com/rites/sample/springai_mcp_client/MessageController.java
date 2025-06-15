package com.rites.sample.springai_mcp_client;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final ChatClient chatClient;

    @GetMapping("/ai")
    public ChatResponse getMessage(@RequestBody String userInput) {
        String response = chatClient
                .prompt()
                .user(userInput)
                .call()
                .content();
        return new ChatResponse(response);
    }

    record ChatResponse(String answer) {}
}
