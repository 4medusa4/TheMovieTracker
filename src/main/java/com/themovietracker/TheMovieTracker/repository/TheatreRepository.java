package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheatreRepository extends MongoRepository<Theatre, String> {
}
