package com.example.aistockconcluder.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "market_type",
        "region",
        "primary_exchanges",
        "local_open",
        "local_close",
        "current_status",
        "notes"})

@Generated("jsonschema2pojo")
public class AlphaVantageResponse {

    @JsonProperty("market_type")
    private String marketType;

    @JsonProperty("region")
    private String region;

    @JsonProperty("primary_exchanges")
    private List<String> primaryExchanges;

    @JsonProperty("local_open")
    private String localopen;

    @JsonProperty("local_close")
    private String localClose;

    @JsonProperty("current_status")
    private String currentStatus;

    @JsonProperty("notes")
    private List<String> additionalNotes;

}
