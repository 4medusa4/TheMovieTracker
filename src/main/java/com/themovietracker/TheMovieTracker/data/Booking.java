package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Booking")
public class Booking {


    @Id
    private int id;
    private LocalDate bookingDate;
    private Time showTime;
    private int numberOfSeats;
    private int numberOfFullSeats;
    private int numberOfHalfSeats;
    private long totalAmount;
    private boolean isPaid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getShowTime() {
        return showTime;
    }

    public void setShowTime(Time showTime) {
        this.showTime = showTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfFullSeats() {
        return numberOfFullSeats;
    }

    public void setNumberOfFullSeats(int numberOfFullSeats) {
        this.numberOfFullSeats = numberOfFullSeats;
    }

    public int getNumberOfHalfSeats() {
        return numberOfHalfSeats;
    }

    public void setNumberOfHalfSeats(int numberOfHalfSeats) {
        this.numberOfHalfSeats = numberOfHalfSeats;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @DocumentReference
    private List<Movie> movieIds;
    @DocumentReference
    private List<Theatre> theatreIds;
    @DocumentReference
    private List<User> userIds;
}
