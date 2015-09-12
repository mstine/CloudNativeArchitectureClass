package io.springbox.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vcarvalho on 5/4/15.
 */
@SpringBootApplication
public class SpringboxResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringboxResourceServerApplication.class);
        app.run(args);
    }


}
