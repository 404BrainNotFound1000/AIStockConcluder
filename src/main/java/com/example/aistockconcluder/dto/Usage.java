package com.example.aistockconcluder.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prompt_tokens",
        "completion_tokens",
        "total_tokens",
        "prompt_tokens_details",
        "completion_tokens_details" })


@Generated("jsonschema2pojo")
public class Usage {


    @JsonProperty("prompt_tokens")
    private Integer promptTokens;
    @JsonProperty("Completion_tokens")
    private Integer completionTokens;
    @JsonProperty("total_tokens")
    private Integer totalTokens;
    @JsonProperty("prompt_tokens_details")
    private PromptTokenDetails promptTokenDetails;
    @JsonProperty("completion_tokens_details")
    private CompletionTokenDetails completionTokenDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();



    //Setters, and getters
    @JsonProperty("prompt_tokens")
    public Integer getPromptTokens() {
        return promptTokens;
    }

    @JsonProperty("prompt_tokens")
    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    @JsonProperty("completion_tokens")
    public Integer getCompletionTokens() {
        return completionTokens;
    }

    @JsonProperty("completion_tokens")
    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    @JsonProperty("total_tokens")
    public Integer getTotalTokens() {
        return totalTokens;
    }

    @JsonProperty("total_tokens")
    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }

    @JsonProperty("prompt_tokens_details")
    public PromptTokenDetails getPromptTokensDetails() {
        return promptTokenDetails;
    }

    @JsonProperty("prompt_tokens_details")
    public void setPromptTokensDetails(PromptTokenDetails promptTokensDetails) {
        this.promptTokenDetails = promptTokensDetails;
    }

    @JsonProperty("completion_tokens_details")
    public CompletionTokenDetails getCompletionTokensDetails() {
        return completionTokenDetails;
    }

    @JsonProperty("completion_tokens_details")
    public void setCompletionTokensDetails(CompletionTokenDetails completionTokensDetails) {
        this.completionTokenDetails = completionTokensDetails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}










