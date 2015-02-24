package io.springbox.consumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/", produces = "application/json")
    String consume() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("PRODUCER", false);

        RestTemplate restTemplate = new RestTemplate();
        ProducerResponse response = restTemplate.getForObject(instance.getHomePageUrl(), ProducerResponse.class);

        return String.format("{\"value\":%d}", response.getValue());
    }

}
