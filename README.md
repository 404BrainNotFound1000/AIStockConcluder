# AIStockConcluder

This application, provides a service to the 

# Tech used: HTML, JS, SpringBoot, Java, Jackson(API), javax

# SpringBoot

## WebClient 

There are two instances of the using the WebClient in this project: 

1 use in ChatGptController

1 use in AlphaVantageAPIService

### Methods employed:

bodyToMono(Object.class) 
This method deserializes the JSON from the body of the HTTP response, into a class specified in the parameter, 
and wraps it in the reactive Mono class, that holds one object. This method can find the JSON element compatible to the 
dto class to be deserialized into. 
The class is instantiated in this parameter with the keyword .class. 
It does this via the JSON schema of defined in this class.

bodyToValue(Object T) 
This method serializes into a JSON format, which Jackson is responsible for. 

retrieve()
This method takes the request into action, sends it and prepares to read the response. It contains basic error handling. 

block()
This method extracts the instantiated and populated object from the asynchronous Mono class instance,
"by waiting for the result so you can use it synchronously in your code."(ChatGPT)

contentType() 
    e.g. contentType(MediaType.APPLICAITION.JSON)

contentType(MediaType.APPLICAITION.JSON), sets the Content-Type header in the HTTP request, which the server can read, and understand, that this request sends content in JSON.

post()
This method initializes the building of an HTTP request. 

baseURL() 
This method adds the base URL, with which HTTP requests initialized with the 

post(), initializes the building of the HTTP request, to the base URL defined in the autowired bean dependency webClient.

get() 








# Jackson 

Jackson project repository: https://github.com/FasterXML/jackson
Jackson faster.xml annotations core module wiki: https://github.com/FasterXML/jackson-annotations/wiki/Jackson-Annotations

### definition 
Jackson is a processor, used in Java applications to process/translate Java data fields into JSON, and conversely JSON into Java data fields. 
Colloquially, this techonology, is also know as "the best JSON parser for Java", or simply "JSON for Java".
Jackson also supports parsing from JSON to other encodings of data, other than Java. 


### Usage of @JsonProperty annotation
The Java data field that you wish to include into serialization into JSON(for shipment to third-party API), is tagged with 
the @JsonProperty annotation directly in the previous line of the data field. In the placeholder parentheses of the annotation, 
a key for the value that the data field holds is defined in "", and is what will point to the value of the data field in the JSON. 

Third-party APIs may only understand specific keys in the JSON that you send to it, so naming them in compliance with the API, and what
keys it knows, is important. 


# Architectural design/Design patterns: DTO  

## DTO 

DTO is short for Data Transfer Object, and this design provides several benefits. 
In general, a key aim of DTOs is to reduce amount of method calls between the layers of the application. 
With DTO design, data is aggregated into clear data structures, which can reduce these method calls. 

Another key benefit of DTO design, can also be, that transfer of data can be set, from a more modular structure. 
This can be beneficial in several contexts, 
such as in data transfer between subsystems in a microservices application, or, similarly in this application, data transfer
between different services of this application, and the APIs of AlphaVantage API and OpenAI API.

[insert: reason for why this is the case in this application] 

In this application, all dto classes are located in the 'dto' folder. 

## config class 

Config class: configuation.WebClientConfig
This configuration class contains a declaration of a WebClient class a bean. It has no baseURL defined, as its purpose is 
to have a factory ready bean of WebClient ready, that can be set with additional properties such as base URL, and api key credential
values. This takes place in the instantiation this bean via constructor injection in the classes that have a need to 
create HTTP requests to a specific third party API.

# Flow(s) of the application
...


####
Template for how this readme is strucutered in paragraphs. 

definition paragraph
 - general benefits 
how employed in this application paragraph 
 - specific benefits 
explanation of specific contents paragraph. 
How to use given technology paragraph 