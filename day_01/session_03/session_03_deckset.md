slidenumbers: true

# [fit] Cloud-Native
# [fit] Application
# [fit] Architectures
# [fit] with Spring and Cloud Foundry
![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)

---

# [fit] Session
# [fit] Three
![](../../Common/images/cf_logo.png)

---

# [fit] Microservices
# [fit] with
# [fit] Polyglot
# [fit] Peristence:
# [fit] Part 1

---

# [fit] Building Your First
# [fit] CLOUD READY
# [fit] Microservice

---

# With Spring Data REST!

```java
@Entity
@Table(name = "city")
public class City implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String county;

  //...

}
```

---

# With Spring Data REST!

```java
@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends PagingAndSortingRepository<City, Long> {}
```

---

# With Spring Data REST!

```java
@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

---

# With Spring Data REST!
```
{
  "_links" : {
    "next" : {
      "href" : "http://localhost:8080/cities?page=1&size=20"
    },
    "self" : {
      "href" : "http://localhost:8080/cities{?page,size,sort}",
      "templated" : true
    }
  },
  "_embedded" : {
    "cities" : [ {
      "name" : "HOLTSVILLE",
      "county" : "SUFFOLK",
      "stateCode" : "NY",
      "postalCode" : "00501",
      "latitude" : "+40.922326",
      "longitude" : "-072.637078",
```

---

# Deploy it to
# Cloud Foundry!
![](../../Common/images/cf_logo.png)

---

# Connect to DB Service Using
# Spring Cloud Connectors!
![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)

---

# [fit] TO THE
# [Fit] LABS!
