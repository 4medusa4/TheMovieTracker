package com.themovietracker.TheMovieTracker.jwt;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, Long> {

    @Query(value = "{'user.id': ?0, $or: [{'expired': false}, {'revoked': false}]}")
    List<Token> findAllValidTokenByUser(long id);
    Optional<Token> findByToken(String token);
}
