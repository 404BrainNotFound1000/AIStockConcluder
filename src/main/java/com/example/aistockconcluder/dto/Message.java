package com.example.aistockconcluder.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude, prohibits null values from being included in the outgoing JSON, which keeps the request clean.
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "role",
        "content",
        "refusal",
        "annotations"
})

//ERROR: You misunderstood this class as being the response from the OpenAI API?

//This class, Message, and its attributes, represent the structure of the request, or response from the OpenAI API. Firstly, they exist primarily to be serialized to JSON, and deserialized from JSON, to Java objects.
@Generated("jsonschema2pojo")
public class Message {

    @JsonProperty("role")
    private String role;
//The key component of the whol API interaction.THE PAYLOAD! The actual data being sent to this application. This exists as a String in the application, deserialized from JSON.
    @JsonProperty("content")
    private String content;
//Holds structured information on a refusal from the OpenAI API, to provide a response. This is written in a [] structure, which can be mapped to an object in the application. The type Object is used, as the schema allows flexibility in formats used for this property.
    @JsonProperty("refusal")
    private Object refusal;

    @JsonProperty("annotations")
    private List<Object> annotations;

    //Catch-all field, used by Jackson, to catch all JSON fields, that are not wxplictiely declared within this class. Key value pairs in this map consist of Object, as flexibility is requiered to catch all additional, unforseen JSON data structures.
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("refusal")
    public Object getRefusal() {
        return refusal;
    }

    @JsonProperty("refusal")
    public void setRefusal(Object refusal) {
        this.refusal = refusal;
    }

    @JsonProperty("annotations")
    public List<Object> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(List<Object> annotations) {
        this.annotations = annotations;
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
