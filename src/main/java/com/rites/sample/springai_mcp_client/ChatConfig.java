package com.rites.sample.springai_mcp_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel chatModel,
                                       SyncMcpToolCallbackProvider toolCallbackProvider) {
        return ChatClient
                .builder(chatModel)
//                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultToolCallbacks(toolCallbackProvider.getToolCallbacks())
                .build();
    }
}
