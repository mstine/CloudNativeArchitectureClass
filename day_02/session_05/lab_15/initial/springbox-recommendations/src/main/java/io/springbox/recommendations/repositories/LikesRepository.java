package io.springbox.recommendations.repositories;

import io.springbox.recommendations.domain.Likes;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface LikesRepository extends GraphRepository<Likes> {
}
