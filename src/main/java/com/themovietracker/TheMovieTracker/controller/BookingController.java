package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(path = "/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping(path="/bookings/{id}")
    public  Booking getBookingById(@PathVariable int id)
    { return bookingService.getBookingById(id);
    }

    @PostMapping(path="/bookings")
    public Booking createBooking(@RequestBody Booking booking)
    { return bookingService.createBooking(booking);
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
