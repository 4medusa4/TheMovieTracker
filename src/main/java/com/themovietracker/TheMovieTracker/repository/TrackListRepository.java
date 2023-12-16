package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.TrackList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackListRepository extends MongoRepository<TrackList, Integer> {
}
