package io.springbox.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringboxProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboxProducerApplication.class, args);
    }

}
