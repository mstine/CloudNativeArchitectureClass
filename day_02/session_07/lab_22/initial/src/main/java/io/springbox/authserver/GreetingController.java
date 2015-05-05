package io.springbox.authserver;

import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vcarvalho on 5/4/15.
 */
@Controller
@EnableOAuth2Resource
public class GreetingController  {

    @RequestMapping("/greeting")
    @ResponseBody
    public Greeting greeting(){
        return new Greeting("Hello user");
    }

}
