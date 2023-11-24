package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.data.Theatre;
import com.themovietracker.TheMovieTracker.data.User;
import com.themovietracker.TheMovieTracker.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private UserService userService;

    public List<Booking> getAllBookings()    //create a method to get movies
    {return bookingRepository.findAll();
    }

    public Booking getBookingById(int id)
    {Optional<Booking> booking1= bookingRepository.findById(id);
        return booking1.get();
    }

    public Booking saveBooking(Booking booking) {
        // Perform any validation or business logic before saving, if needed

        // Set booking details
        booking.setBookingDate(LocalDate.now());
        // Example: Calculate total amount based on seat counts and other factors
        long totalAmount = calculateTotalAmount(booking);
        booking.setTotalAmount(totalAmount);

        // Example: Update seat counts in the theatre and movie
        updateSeatCounts(booking);

        // Example: Perform additional business logic or validation

        // Save the booking
        return bookingRepository.save(booking);
    }

    private long calculateTotalAmount(Booking booking) {
        // Add logic to calculate total amount based on seat counts, pricing, etc.
        // For simplicity, let's assume a fixed price per seat
        int pricePerSeat = 10;
        return booking.getNumberOfSeats() * pricePerSeat;
    }

    private void updateSeatCounts(Booking booking) {
        // Example: Update seat counts in the associated theatre and movie
        // You need to implement these methods in TheatreService and MovieService
        Optional<Theatre> theatreOptional = theatreService.getTheatreById(String.valueOf(booking.getTheatreIds().get(0)));
        Optional<Movie> movieOptional = movieService.getMovieById(booking.getMovieIds().get(0));

        if (theatreOptional.isPresent() && movieOptional.isPresent()) {
            Theatre theatre = theatreOptional.get();
            Movie movie = movieOptional.get();

            // Update seat counts
            theatreService.bookSeats(theatre, booking.getNumberOfSeats());
            movieService.bookSeats(movie, booking.getNumberOfSeats());
        }
    }

    public Booking updateBooking(Booking booking){

        return bookingRepository.save(booking);
    }

    public void deleteBookingById(int id){

        bookingRepository.deleteById(id);
    }

    public Booking createBooking(Booking booking) {

        return bookingRepository.save(booking);
    }
}
