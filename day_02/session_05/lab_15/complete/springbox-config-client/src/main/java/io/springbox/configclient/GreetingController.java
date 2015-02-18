package io.springbox.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    Greeter greeter;

    @RequestMapping("/")
    public String greeter() {
        return greeter.getGreeting() + " World!";
    }

}
