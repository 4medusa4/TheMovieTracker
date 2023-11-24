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

//    public Booking bookTicket(String userId, String movieId, String theatreId, Booking booking) {
//        // Validate the existence of user, movie, and theatre
//        Optional<User> userOptional = userService.getUserById(userId);
//        Optional<Movie> movieOptional = movieService.getMovieById(movieId);
//        Optional<Theatre> theatreOptional = theatreService.getTheatreById(theatreId);
//
//        if (userOptional.isEmpty() || movieOptional.isEmpty() || theatreOptional.isEmpty()) {
//            // Handle invalid user, movie, or theatre
//            throw new IllegalArgumentException("Invalid user, movie, or theatre.");
//        }
//
//        User user = userOptional.get();
//        Movie movie = movieOptional.get();
//        Theatre theatre = theatreOptional.get();
//
//        // Set booking details
//        booking.setBookingDate(LocalDate.now());
//        booking.setUser(user);
//        booking.setMovie(movie);
//        booking.setTheatre(theatre);
//
//        // Update seat counts in the theatre and movie
//        theatreService.bookSeats(theatre, booking.getNumberOfSeats());
//        movieService.bookSeats(movie, booking.getNumberOfSeats());
//
//        // Calculate total amount based on seat counts and other factors
//        long totalAmount = calculateTotalAmount(booking);
//        booking.setTotalAmount(totalAmount);
//
//        // Perform any additional business logic or validation
//
//        // Save the booking
//        return bookingRepository.save(booking);
//    }

    private long calculateTotalAmount(Booking booking) {
        // Add logic to calculate total amount based on seat counts, pricing, etc.
        // For simplicity, let's assume a fixed price per seat
        int pricePerSeat = 10;
        return booking.getNumberOfSeats() * pricePerSeat;
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
