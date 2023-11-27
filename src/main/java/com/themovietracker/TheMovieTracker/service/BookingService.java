package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.helpers.SequenceGeneratorService;
import com.themovietracker.TheMovieTracker.repository.BookingRepository;
import com.themovietracker.TheMovieTracker.user.UserService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final MovieService movieService;
    private final TheatreService theatreService;
    private final UserService userService;
    private final SequenceGeneratorService sequenceGenerator;

    public List<Booking> getAllBookings()    //create a method to get movies
    {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        Optional<Booking> booking1 = bookingRepository.findById(id);
        return booking1.get();
    }

    public Booking saveBooking(@NotNull Booking booking) {
        // Perform any validation or business logic before saving, if needed

        // Set booking details
        booking.setId(sequenceGenerator.generateSequence(Booking.SEQUENCE_NAME));
        booking.setDate(new Date(System.currentTimeMillis()));
        // Example: Calculate total amount based on seat counts and other factors
        long totalAmount = calculateTotalAmount(booking);
        // Example: Update seat counts in the theatre and movie
        updateSeatCounts(booking);

        // Example: Perform additional business logic or validation

        // Save the booking
        return bookingRepository.save(booking);
    }

    @Contract(pure = true)
    private long calculateTotalAmount(@NotNull Booking booking) {
        // Add logic to calculate total amount based on seat counts, pricing, etc.
        // For simplicity, let's assume a fixed price per seat
        int pricePerSeat = 10;
        return (long) booking.getSeats().size() * pricePerSeat;
    }

    private void updateSeatCounts(@NotNull Booking booking) {
        // Example: Update seat counts in the associated theatre and movie
        // You need to implement these methods in TheatreService and MovieService

        /*Optional<Theatre> theatreOptional = theatreService.getTheatreById(String.valueOf(booking.getTheatreIds().get(0)));
        Optional<Movie> movieOptional = movieService.getMovieById(booking.getMovieIds().get(0));

        if (theatreOptional.isPresent() && movieOptional.isPresent()) {
            Theatre theatre = theatreOptional.get();
            Movie movie = movieOptional.get();

            // Update seat counts
            theatreService.bookSeats(theatre, booking.getSeats().size());
            movieService.bookSeats(movie,  booking.getSeats().size());

        }*/
    }

    public Booking updateBooking(Booking booking) {

        return bookingRepository.save(booking);
    }

    public void deleteBookingById(int id) {

        bookingRepository.deleteById(id);
    }

    public Booking createBooking(Booking booking) {

        return bookingRepository.save(booking);
    }
}
