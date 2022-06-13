package com.springboot.learn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AppContext {
    private Date requestStartTime;
    private Date requestEndTime;

    public AppContext() {
        requestStartTime = new Date();
    }

    public double timeTaken(){
        requestEndTime = new Date();
        return (requestEndTime.getTime() - requestStartTime.getTime());
    }
}
