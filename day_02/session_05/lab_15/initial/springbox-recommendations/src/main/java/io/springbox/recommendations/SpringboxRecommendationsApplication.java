package io.springbox.recommendations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "io.springbox.recommendations.repositories")
public class SpringboxRecommendationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboxRecommendationsApplication.class, args);
    }
}
