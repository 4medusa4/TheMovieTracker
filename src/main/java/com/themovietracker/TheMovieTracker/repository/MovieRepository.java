package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> getMovieById(long id);

    List<Movie> findByReleaseDateBefore(Date releaseDate);
}