package io.springbox.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class Greeter {

    @Value("${greeting}")
    private String greeting;

    public String getGreeting() {
        return greeting;
    }
}
