package com.example.aistockconcluder.dto;


import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@JsonInclude, prohibits null values from being included in the outgoing JSON, which keeps the request clean.
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "object",
        "created",
        "model",
        "choices",
        "usage",
        "service_tier",
        "system_fingerprint"
})

//This class focuses on deserializing the response from OpenAI API from JSON, into usable Java format.
@Generated("jsonschema2pojo")
public class ChatResponse {

    //id, is a unique identifier for the specific response OpenAI API. Usefull for debugging/logging.
    @JsonProperty("id")
    private String id;

    //object, contains information about what kind of response the response is. (e.g. "chat.completion").
    @JsonProperty("object")
    private String object;

    //created, a timestamp value, of when the response was generated.
    @JsonProperty("created")
    private Integer created;

    //model, contains information on what specific model, it was, that created the repsonse.
    @JsonProperty("model")
    private String model;

    //choices, an important variable to the purpose of the application. The actual PAYLOAD of the interaction - what you'd like to present to the end-user, or demontrate in Postman.
    @JsonProperty("choices")
    private List<Choice> choices;

    @JsonProperty("usage")
    private Usage usage;

    @JsonProperty("service_tier")
    private String serviceTier;

    @JsonProperty("System_fingerprint")
    private Object systemFingerprint;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    //getters

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("object")
    public String getObject() {
        return object;
    }

    @JsonProperty("created")
    public Integer getCreated() {
        return created;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("choices")
    public List<Choice> getChoices() {
        return choices;
    }

    @JsonProperty("usage")
    public Usage getUsage() {
        return usage;
    }

    @JsonProperty("service_tier")
    public String getServiceTier() {
        return serviceTier;
    }

    @JsonProperty("system_fingerprint")
    public Object getSystemFingerprint() {
        return systemFingerprint;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    //setters


    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("object")
    public void setObject(String object) {
        this.object = object;
    }

    @JsonProperty("created")
    public void setCreated(Integer created) {
        this.created = created;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("choices")
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    @JsonProperty("usage")
    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @JsonProperty("service_tier")
    public void setServiceTier(String serviceTier) {
        this.serviceTier = serviceTier;
    }

    @JsonProperty("system_fingerprint")
    public void setSystemFingerprint(Object systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
