package io.springbox.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringboxConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboxConsumerApplication.class, args);
    }
}
