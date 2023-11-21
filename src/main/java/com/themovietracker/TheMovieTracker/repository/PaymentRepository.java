package com.themovietracker.TheMovieTracker.repository;

import com.themovietracker.TheMovieTracker.data.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
