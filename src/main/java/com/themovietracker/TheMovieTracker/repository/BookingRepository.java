package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookingRepository extends MongoRepository<Booking, Integer> {
}
