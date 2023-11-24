package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Tracklist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TracklistRepository extends MongoRepository<Tracklist, Integer> {
}
