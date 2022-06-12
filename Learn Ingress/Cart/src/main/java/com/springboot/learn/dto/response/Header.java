package com.springboot.learn.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header {
    @JsonProperty("TimeTaken")
    String timeTaken;
    @JsonProperty("Status")
    Integer status;
    @JsonProperty("Message")
    String message;
    @JsonProperty("MessageCode")
    String messageCode;
}
