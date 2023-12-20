package com.themovietracker.TheMovieTracker.controller;

import com.mongodb.lang.Nullable;
import com.themovietracker.TheMovieTracker.data.Payment;
import com.themovietracker.TheMovieTracker.service.PaymentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payment")
public class PaymentController{
    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "/payments", produces = MediaType.APPLICATION_JSON_VALUE, name = "getPayments")
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<>(this.paymentService.getPayments(), HttpStatus.OK);
    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, name = "savePayment")
    public ResponseEntity<Long> savePayment(@RequestBody @NotNull Payment payment){
        return new ResponseEntity<>(this.paymentService.savePayment(payment), HttpStatus.OK);
    }
}
