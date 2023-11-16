package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Optional;

public interface ShowRepository extends MongoRepository<Show, String> {
    Optional<Show> getShowById(int id);

    Optional<Show> getShowByStartTime(Time startTime);
    @Query("{'id':?0, 'showDate':?1, 'showTime':?3}")
    void updateShow(int id, Time startTime, double ticketPrice);
}
