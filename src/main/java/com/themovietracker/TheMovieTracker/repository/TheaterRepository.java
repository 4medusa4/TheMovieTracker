package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TheaterRepository extends MongoRepository<Theater, String> {
}
