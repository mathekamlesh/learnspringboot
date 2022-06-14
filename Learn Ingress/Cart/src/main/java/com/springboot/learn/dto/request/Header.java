package com.springboot.learn.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    @JsonProperty("DeviceId")
    private String deviceId;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("RequestTime")
    private String requestTime;
    @JsonProperty("RequestId")
    private String requestId;
}
