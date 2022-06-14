package com.springboot.learn;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Getter
@Setter
@SessionScope
@Component
public class AppContext {
    private Date requestStartTime;
    private Date requestEndTime;
    private TimeUnit timeUnit;

    public AppContext() {
        requestStartTime = new Date();
    }

    public Long timeTaken() {
        requestEndTime = new Date();
        long diffInMillies = (requestEndTime.getTime() - requestStartTime.getTime());
        return diffInMillies;
    }
}
