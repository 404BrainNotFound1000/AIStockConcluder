package com.example.aistockconcluder.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "model",
        "messages",
        "n",
        "temperature",
        "max_tokens",
        "stream",
        "presence_penalty"
})
@Generated("jsonschema2pojo")
public class ChatRequest {

    //Data fields

    @JsonProperty("model")
    private String model;

    @JsonProperty("messages")
    private List<Message> messages;

    @JsonProperty("n")
    private Integer n;

    @JsonProperty("temperature")
    private Integer temperature;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("stream")
    private Boolean stream;

    @JsonProperty("presence_penalty")
    private Integer presencePenalty;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


    //Getters
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("n")
    public Integer getN() {
        return n;
    }

    @JsonProperty("temperature")
    public Integer getTemperature() {
        return temperature;
    }

    @JsonProperty("max_tokens")
    public Integer getMaxTokens() {
        return maxTokens;
    }

    @JsonProperty("stream")
    public Boolean getStream() {
        return stream;
    }

    @JsonProperty("presence_penalty")
    public Integer getPresencePenalty() {
        return presencePenalty;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    //Setters


    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }
    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    @JsonProperty("n")
    public void setN(Integer n) {
        this.n = n;
    }
    @JsonProperty("temperature")
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    @JsonProperty("max_tokens")
    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }
    @JsonProperty("stream")
    public void setStream(Boolean stream) {
        this.stream = stream;
    }
    @JsonProperty("presence_penalty")
    public void setPresencePenalty(Integer presencePenalty) {
        this.presencePenalty = presencePenalty;
    }
    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
