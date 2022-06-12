package com.springboot.learn.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    @JsonProperty("Header")
    Header header;
    @JsonProperty("Body")
    Body<T> body;
}
