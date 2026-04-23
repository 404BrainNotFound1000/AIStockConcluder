package com.example.aistockconcluder.service;

import com.example.aistockconcluder.dto.AlphaVantageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;

@Service
public class AlphaVantageAPIService {

    @Value("${alpha.vantage.key}")
    public String alphaVantageKey;


    private final WebClient webClient;

    public AlphaVantageAPIService(WebClient.Builder webClientBuilder, @Value("${alpha.vantage.key}") String alphaVantageKey) {
        this.webClient = webClientBuilder.baseUrl("https://www.alphavantage.co").build();
        this.alphaVantageKey = alphaVantageKey;
    }

    //Get API JSON - Major Stock Exchanges Status
    public AlphaVantageResponse getStatusMarketGlobal() {
        AlphaVantageResponse response = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/query")
                                .queryParam("function", "MARKET_STATUS")
                                .queryParam("apikey", alphaVantageKey)
                                .build())
                .retrieve()
                .bodyToMono(AlphaVantageResponse.class)
                .block();
        //bodyToMono() ''tells spring'' to deserialize the HTTP response, into a ChatResponse class. In other words, it manages to find the JSON variable name, and convert it into the predefined Java variables, via the JSON Schema.
        return response;
    }
}
