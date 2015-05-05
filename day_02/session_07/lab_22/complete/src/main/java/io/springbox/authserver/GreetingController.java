package io.springbox.authserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vcarvalho on 5/4/15.
 */
@RestController
public class GreetingController  {

    @RequestMapping("/greeting")
    public Greeting greeting(){
        return new Greeting("Hello user");
    }

}
