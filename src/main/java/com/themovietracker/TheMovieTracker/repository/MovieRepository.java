package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
