package com.example.aistockconcluder.controller;

import com.example.aistockconcluder.configuration.webClientConfig;
import com.example.aistockconcluder.dto.*;
import com.example.aistockconcluder.service.AlphaVantageAPIService;
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
    private final AlphaVantageAPIService alphaVantageAPIService;

    @Value("${openai.api.key}")
    private String openapikey;

    @Autowired
    public ChatGptController(WebClient.Builder webClientBuilder, AlphaVantageAPIService alphaVantageAPIService) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/chat/completions").build();
        this.alphaVantageAPIService = alphaVantageAPIService;
    }

    @GetMapping("/hej")
    public String hej() {
        return "Hej" + openapikey;
    }

    @GetMapping("/chat")
    //@RequestParam, is used to extract the query String message from the request?(At the call of this method, there is made an independent request.
    //Map<String, Object is used to store WHAT?

    //For adding user input, in a method parameter in this controller method, add @RequestParam
    public Map<String, Object> chatWithGpt() {
        ChatRequest chatRequest = new ChatRequest();
        AlphaVantageResponse alphaVantageResponse = new AlphaVantageResponse();
        chatRequest.setModel("gpt-3.5-turbo");
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message("system", "Firstly, please write which major stock exchanges are open, from what you receive from me. Lastly, please respond in academic terms, on the status of global stock exchanges, and add general info, such as regular hours having the most trading volume, and other trivial info about the stock exchanges."));
        lstMessage.add(new Message("user", "What are major stock exchanges?"));

        AlphaVantageResponse responseJSON = alphaVantageAPIService.getStatusMarketGlobal();
        //Or use StringBuilder
        String responseString = responseJSON.toString();
        lstMessage.add(new Message("system", responseString));

        chatRequest.setMessages(lstMessage);
        chatRequest.setN(1);
        chatRequest.setTemperature(1);
        chatRequest.setMaxTokens(200);
        chatRequest.setStream(false);
        chatRequest.setPresencePenalty(0);

        //Several actions are started and completed with return values in this part of the method:
        //Returns a ChatResponse(instead of just assigning it to a variable for 'internal processing'), as Spring expects an outpout to serialize, to be sent over HTTP. A design, is to have the method return chatResponse in the same scope, in which attributes of the chatResponse can be extracted from.

        //Description of methods:
        //post(), initializes the building of the HTTP request, to the base URL defined in the autowired bean dependency webClient.
        //contentType(MediaType.APPLICAITION.JSON), sets the Content-Type header in the HTTP request, which the server can read, and understand, that this request sends content in JSON.
        //headers(h -> h.setBearerAuth(openapikey)), adds a header: Authentication: Bearer <key>, for authentication.
        //bodyToValue(), serializes a specific object into a JSON format, which Jackson does, for the request body.
        //retrieve(), actually performs the request, and sends it, AND, prepares to read the response, with basic error handling.
        //bodyToMono(Object.class), ''tells Spring'', to take the JSON from the RESPONSE body, and deserialize it into a compatible class, namely ChatResponse, in this case, wrapped om a reactive Mono class.
        //block(), converts the asynchronous Mono, into a concrete ChatResponse object "by waiting for the result so you can use it synchronously in your code."(ChatGPT)

        ChatResponse chatResponse = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(h-> h.setBearerAuth(openapikey))
                //Chatrequest med messages til OpenAI API, og attributværdier.
                .bodyValue(chatRequest)
                .retrieve()
                //bodyToMono() ''tells spring'' to deserialize the HTTP response, into a ChatResponse class. In other words, it manages to find the JSON variable name, and convert it into the predefined Java variables, via the JSON Schema.
                .bodyToMono(ChatResponse.class)
                .block();

        List<Choice> lst = chatResponse.getChoices();
        Usage usg = chatResponse.getUsage();

        Map<String, Object> map = new HashMap<>();
        map.put("Usage", usg);
        map.put("Choices", lst);
        //map, is what is to be serialized to JSON.
        return map;
    }

}