# AIStockConcluder

This application, provides a service to the 

# Tech used: HTML, JS, SpringBoot, Java, Jackson(API), javax

# SpringBoot 

## WebClient 

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


# Flow(s) of the application



####
Template for how this readme is strucutered in paragraphs. 

definition paragraph
 - general benefits 
how employed in this application paragraph 
 - specific benefits 
explanation of specific contents paragraph. 
How to use given technology paragraph 