package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
