package io.springbox.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("producer")
public interface ProducerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ProducerResponse getValue();
}
