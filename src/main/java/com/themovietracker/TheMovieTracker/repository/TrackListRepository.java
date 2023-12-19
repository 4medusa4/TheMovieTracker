package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.TrackList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackListRepository extends MongoRepository<TrackList, Integer> {

    List<TrackList> findByMovieId(long movieId);
}
