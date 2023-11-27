package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tenant")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping(path = "/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping(path="/bookings/{id}")
    public  Booking getBookingById(@PathVariable int id)
    { return bookingService.getBookingById(id);
    }

    @PostMapping(path = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE, name = "createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return new ResponseEntity<>(this.bookingService.saveBooking(booking), HttpStatus.OK);
    }

    @PutMapping(path="/bookings")
    public Booking updateBooking(@RequestBody Booking booking)
    { return bookingService.updateBooking(booking);
    }

    @DeleteMapping(path="/bookings/{id}")
    public void deleteBookingById(@PathVariable int id)
    { bookingService.deleteBookingById(id);
    }
}
