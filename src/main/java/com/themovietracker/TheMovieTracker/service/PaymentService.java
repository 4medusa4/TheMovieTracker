package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Payment;
import com.themovietracker.TheMovieTracker.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPayments(){
        return this.paymentRepository.findAll();
    }

    public long savePayment(Payment payment){
        return this.paymentRepository.save(payment).getId();
    }
}
