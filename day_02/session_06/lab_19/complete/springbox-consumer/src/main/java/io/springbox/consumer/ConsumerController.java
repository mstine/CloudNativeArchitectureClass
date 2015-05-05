package io.springbox.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    ProducerClient producerClient;

    @RequestMapping(value = "/", produces = "application/json")
    String consume() {
        ProducerResponse response = producerClient.getValue();
        return String.format("{\"value\":%d}", response.getValue());
    }

}
