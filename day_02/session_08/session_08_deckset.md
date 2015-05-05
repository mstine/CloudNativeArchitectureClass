slidenumbers: true

# [fit] Cloud-Native
# [fit] Application
# [fit] Architectures
# [fit] with Spring and Cloud Foundry
![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)

---

# [fit] Session
# [fit] Eight
![](../../Common/images/cf_logo.png)

---

# [fit] The API
# [fit] Gateway
# [fit] Pattern

---

# API Gateway Pattern
![inline](../../Common/images/API_Gateway.png)

---

![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)
# [fit] Reverse
# [fit] Proxy

---

# [fit] Zuul
![](../../Common/images/netflix_oss.jpeg)

---

```
zuul:
  routes:
    springbox-catalog: /catalog/**
    springbox-reviews: /reviews/**
    springbox-recommendations: /recommendations/**
```

---

![](https://raw.githubusercontent.com/spring-projects/spring-cloud/gh-pages/img/project-icon-large.png)
# [fit] Concurrent
# [fit] API
# [fit] Aggregation &
# [fit] Transformation

---

# [fit] RxJava
![](../../Common/images/netflix_oss.jpeg)

---

# Movie Catalog Service

```java
@RequestMapping(value = "/catalog/movies/{mlId}", method = RequestMethod.GET)
public Movie movie(@PathVariable String mlId) {
  return movieRepository.findByMlId(mlId);
}
```

---

# Movie Catalog Service

```
{
  id: 1001,
  title: "GoldenEye (1995)",
  mlId: "2",
  genres: [
  {
    id: 1001,
    mlId: "1",
    name: "Action"
  },
  {
    id: 1002,
    mlId: "2",
    name: "Adventure"
  },
  {
    id: 1016,
    mlId: "16",
    name: "Thriller"
  }
  ]
}
```

---

# Movie Review Service

```java
@RequestMapping(value = "/reviews/reviews/{mlId}", method = RequestMethod.GET)
public Iterable<Review> reviews(@PathVariable String mlId) {
  return reviewRepository.findByMlId(mlId);
}
```

---

# Movie Review Service

```
[
{
  id: "54b85cbe004e0464177e90e4",
  mlId: "2",
  userName: "mstine",
  title: "GoldenEye (1995)",
  review: "Pretty good...",
  rating: 3
},
{
  id: "54b85cbe004e0464177e90e5",
  mlId: "2",
  userName: "starbuxman",
  title: "GoldenEye (1995)",
  review: "BOND BOND BOND!",
  rating: 5
},
{
  id: "54b85cbf004e0464177e90e8",
  mlId: "2",
  userName: "littleidea",
  title: "GoldenEye (1995)",
  review: "Good show!",
  rating: 4
}
]
```

---

# Movie Recommendations Service

```java
public interface MovieRepository extends GraphRepository<Movie> {
  Movie findByMlId(String mlId);

  @Query("MATCH (movie:Movie) WHERE movie.mlId = {0} MATCH movie<-[:LIKES]-slm-[:LIKES]->recommendations " +
  "RETURN distinct recommendations")
  Iterable<Movie> moviesLikedByPeopleWhoLiked(String mlId);
}
```

---

# Movie Recommendations Service

```java
@RequestMapping(value = "/recommendations/forMovie/{mlId}", method = RequestMethod.GET)
public Iterable<Movie> recommendedMoviesForMovie(@PathVariable String mlId) {
  return movieRepository.moviesLikedByPeopleWhoLiked(mlId);
}
```

---

# Movie Recommendations Service

```java
@RequestMapping(value = "/recommendations/forMovie/{mlId}", method = RequestMethod.GET)
public Iterable<Movie> recommendedMoviesForMovie(@PathVariable String mlId) {
  return movieRepository.moviesLikedByPeopleWhoLiked(mlId);
}
```

---

# Movie Recommendations Service

```
[
{
  id: 6,
  mlId: "1",
  title: "Toy Story (1995)"
},
{
  id: 1,
  mlId: "4",
  title: "Get Shorty (1995)"
},
{
  id: 2,
  mlId: "5",
  title: "Copycat (1995)"
},
{
  id: 0,
  mlId: "3",
  title: "Four Rooms (1995)"
}
]
```

---

# [fit] API
# [fit] Gateway

---

# Catalog Integration Service

```java
@Service
public class CatalogIntegrationService {

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "stubMovie")
  public Observable<Movie> getMovie(final String mlId) {
    return new ObservableResult<Movie>() {
      @Override
      public Movie invoke() {
        return restTemplate.getForObject("http://catalog-service/catalog/movies/{mlId}", Movie.class, mlId);
      }
    };
  }

  private Movie stubMovie(final String mlId) {
    Movie stub = new Movie();
    stub.setMlId(mlId);
    stub.setTitle("Interesting...the wrong title. Sssshhhh!");
    return stub;
  }
}
```

---

# Reviews Integration Service

```java
@Service
public class ReviewsIntegrationService {

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "stubReviews")
  public Observable<List<Review>> reviewsFor(String mlId) {
    return new ObservableResult<List<Review>>() {
      @Override
      public List<Review> invoke() {
        ParameterizedTypeReference<List<Review>> responseType = new ParameterizedTypeReference<List<Review>>() {
        };
        return restTemplate.exchange("http://reviews-service/reviews/reviews/{mlId}", HttpMethod.GET, null, responseType, mlId).getBody();
      }
    };
  }

  private List<Review> stubReviews(String mlId) {
    Review review = new Review();
    review.setMlId(mlId);
    review.setRating(4);
    review.setTitle("Interesting...the wrong title. Sssshhhh!");
    review.setReview("Awesome sauce!");
    review.setUserName("joeblow");
    return Arrays.asList(review);
  }

}
```

---

# Recommendations Integration Service

```java
@Service
public class RecommendationsIntegrationService {
  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "stubRecommendations")
  public Observable<List<Movie>> getRecommendations(final String mlId) {
    return new ObservableResult<List<Movie>>() {
      @Override
      public List<Movie> invoke() {
        ParameterizedTypeReference<List<Movie>> responseType = new ParameterizedTypeReference<List<Movie>>() {
        };
        return restTemplate.exchange("http://recommendations-service/recommendations/forMovie/{mlId}", HttpMethod.GET, null, responseType, mlId).getBody();
      }
    };
  }

  private List<Movie> stubRecommendations(final String mlId) {
    Movie one = new Movie();
    one.setMlId("25");
    one.setMlId("A movie which doesn't exist");
    Movie two = new Movie();
    two.setMlId("26");
    two.setMlId("A movie about nothing");
    return Arrays.asList(one, two);
  }
}
```

---

# Concurrently Aggregate and Transform

```java
@RequestMapping("/movie/{mlId}")
public DeferredResult<MovieDetails> movieDetails(@PathVariable String mlId) {
  Observable<MovieDetails> details = Observable.zip(

  catalogIntegrationService.getMovie(mlId),
  reviewsIntegrationService.reviewsFor(mlId),
  recommendationsIntegrationService.getRecommendations(mlId),

  (movie, reviews, recommendations) -> {
    MovieDetails movieDetails = new MovieDetails();
    movieDetails.setMlId(movie.getMlId());
    movieDetails.setTitle(movie.getTitle());
    movieDetails.setReviews(reviews);
    movieDetails.setRecommendations(recommendations);
    return movieDetails;
  }

  );
  return toDeferredResult(details);
}
```

---

# [fit] TO THE
# [Fit] LABS!
