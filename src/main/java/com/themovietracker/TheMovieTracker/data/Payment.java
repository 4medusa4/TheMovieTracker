package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;

import java.util.Date;

public class Payment {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Time getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Time paymentTime) {
        this.paymentTime = paymentTime;
    }

    private Long id;
    private Long amount;
    private Date paymentdate;
    private Time paymentTime;

    public Payment() {
    }

    public Payment(Long id, Long amount, Date paymentdate, Time paymentTime) {
        this.id = id;
        this.amount = amount;
        this.paymentdate = paymentdate;
        this.paymentTime = paymentTime;
    }
}
