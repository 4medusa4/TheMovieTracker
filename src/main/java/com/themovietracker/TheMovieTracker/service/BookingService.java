package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings()    //create a method to get movies
    {return bookingRepository.findAll();
    }

    public Booking getBookingById(int id)
    {Optional<Booking> booking1= bookingRepository.findById(id);
        return booking1.get();
    }

    public Booking createBooking(Booking booking1){
        return bookingRepository.save(booking1);
    }

    public Booking updateBooking(Booking booking1){
        return bookingRepository.save(booking1);
    }

    public void deleteBookingById(int id){
        bookingRepository.deleteById(id);

    }

}
