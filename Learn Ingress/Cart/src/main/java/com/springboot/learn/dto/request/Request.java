package com.springboot.learn.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request<T> {
    @JsonProperty("Header")
    private Header header;
    @JsonProperty("Body")
    private T body;
}
