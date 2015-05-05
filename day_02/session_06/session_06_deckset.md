slidenumbers: true

# [fit] Cloud-Native
# [fit] Application
# [fit] Architectures
# [fit] with Spring and Cloud Foundry
![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)

---

# [fit] Session
# [fit] Six
![](../../Common/images/cf_logo.png)

---

# [fit] Cloud-Native
# [fit] Architecture
# [fit] Patterns:
# [fit] Part 2

---

# Patterns On-Deck

* Routing/Load Balancing
* Fault Tolerance

---

![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)
# [fit] Routing &
# [fit] Load Balancing

---

![inline fit](../../Common/images/Ribbon.png)

---

# [fit] Ribbon
![](../../Common/images/netflix_oss.jpeg)

---

# Consumer with Load Balancer

```java
@Autowired
LoadBalancerClient loadBalancer

@RequestMapping("/")
String consume() {
  ServiceInstance instance = loadBalancer.choose("producer")
  URI producerUri = URI.create("http://${instance.host}:${instance.port}");

  RestTemplate restTemplate = new RestTemplate()
  ProducerResponse response = restTemplate.getForObject(producerUri, ProducerResponse.class)

  "{\"value\": ${response.value}}"
}
```

---

# Consumer with Ribbon-enabled `RestTemplate`

```java
@Autowired
RestTemplate restTemplate

@RequestMapping("/")
String consume() {
  ProducerResponse response = restTemplate.getForObject("http://producer", ProducerResponse.class)

  "{\"value\": ${response.value}}"
}
```

---

# Feign Client

```java
@FeignClient("producer")
public interface ProducerClient {

  @RequestMapping(method = RequestMethod.GET, value = "/")
  ProducerResponse getValue();
}
```

---

# Consumer with Feign Client

```java
@SpringBootApplication
@FeignClientScan
@EnableDiscoveryClient
@RestController
public class Application {

  @Autowired
  ProducerClient client;

  @RequestMapping("/")
  String consume() {
    ProducerResponse response = client.getValue();

    return "{\"value\": " + response.getValue() + "}";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

---

![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)
# [fit] Fault
# [fit] Tolerance

---

# [fit] Hystrix
![](../../Common/images/netflix_oss.jpeg)

---

# Circuit Breaker
![inline](../../Common/images/circuit-breaker.gif)

---

# Consumer `app.groovy`

```java
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class Application {

  @Autowired
  ProducerClient client

  @RequestMapping("/")
  String consume() {
    ProducerResponse response = client.getProducerResponse()

    "{\"value\": ${response.value}}"
  }

}
```

---

# Producer Client

```java
@Component
public class ProducerClient {

  @Autowired
  RestTemplate restTemplate

  @HystrixCommand(fallbackMethod = "getProducerFallback")
  ProducerResponse getProducerResponse() {
    restTemplate.getForObject("http://producer", ProducerResponse.class)
  }

  ProducerResponse getProducerFallback() {
    new ProducerResponse(value: 42)
  }
}
```

---

![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)
# [fit] Monitoring

---

# [fit] Hystrix
# [fit] Dashboard
![](../../Common/images/netflix_oss.jpeg)

---

# Hystrix Dashboard

![inline](../../Common/images/hystrix-dashboard.png)

---

# Hystrix Dashboard

```java
@Grab("org.springframework.cloud:spring-cloud-starter-hystrix-dashboard:1.0.0.RC1")

import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@EnableHystrixDashboard
class HystrixDashboard {
}
```

---

# [fit] TO THE
# [fit] LABS!
