package io.springbox.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ProducerController {

    private Log log = LogFactory.getLog(ProducerController.class);
    private AtomicInteger counter = new AtomicInteger(0);

    @RequestMapping(value = "/", produces = "application/json")
    public String produce() {
        int value = counter.getAndIncrement();
        log.info("Produced a value: " + value);

        return String.format("{\"value\":%d}", value);
    }

}
