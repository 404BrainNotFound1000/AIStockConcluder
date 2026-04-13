package com.example.aistockconcluder.controller;

import com.example.aistockconcluder.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatGptController {

    private final WebClient webClient;

    @Autowired
    public ChatGptController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/chat/completions").build();
    }

    @Value("${openai.api.key}")
    private String openapikey;


    @GetMapping("/hej")
    public String hej() {
        return "Hej" + openapikey;
    }

    @GetMapping("/chat")
    public Map<String, Object> chatWithGpt(@RequestParam String message) {
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("gpt-3.5-turbo");
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message("system", "You are a helpful assistan."));
        lstMessage.add(new Message("user", "Where is " + message + "?"));
        chatRequest.setMessages(lstMessage);
        chatRequest.setN(3);
        chatRequest.setTemperature(1);
        chatRequest.setMaxTokens(200);
        chatRequest.setStream(false);
        chatRequest.setPresencePenalty(1);

        ChatResponse chatResponse = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(h-> h.setBearerAuth(openapikey))
                .bodyValue(chatRequest)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();

        List<Choice> lst = chatResponse.getChoices();
        Usage usg = chatResponse.getUsage();

        Map<String, Object> map = new HashMap<>();
        map.put("Usage", usg);
        map.put("Choices", lst);
        return map;
    }


}