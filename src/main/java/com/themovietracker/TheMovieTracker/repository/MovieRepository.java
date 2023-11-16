package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> getMovieById(int id);
}