package io.springbox.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "producer", configuration = ProducerConfiguration.class)
public class SpringboxConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboxConsumerApplication.class, args);
    }
}
