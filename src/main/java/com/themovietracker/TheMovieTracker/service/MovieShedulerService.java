package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Booking;
import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.data.TrackList;
import com.themovietracker.TheMovieTracker.repository.BookingRepository;
import com.themovietracker.TheMovieTracker.repository.MovieRepository;
import com.themovietracker.TheMovieTracker.repository.TrackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartFile;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
public class MovieShedulerService {

    @Autowired
    private TrackListRepository trackListRepository;

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 0 * * *") // Run the task daily at midnight
    public void copyMoviesToBookings() {
        Date date = new Date(System.currentTimeMillis());
        // Add 5 days (5 * 24 * 60 * 60 * 1000 milliseconds)
        long millisToAdd = 5L * 24 * 60 * 60 * 1000;
        Date fiveDaysAfter = new Date(date.getTime() + millisToAdd);

        List<Movie> moviesToCopy = movieRepository.findByReleaseDateBefore(fiveDaysAfter);

        for (Movie movie : moviesToCopy) {
            List<TrackList> trackListData = trackListRepository.findByMovieId(movie.getId());

            for (TrackList trackList : trackListData) {
                Booking booking = createBookingFromTrackList(trackList);
                Booking savedBooking = bookingRepository.save(booking);

                if (savedBooking != null) {
                    // The save operation was successful
                    // You can perform additional actions or log a success message
                    System.out.println("Booking saved successfully: " + savedBooking.getId());
                    MultipartFile[] file = {};
                    emailService.sendMail(file, "imeshalakshani007@gmail.com", new String[] {"warunamadushanka456@gmail.com"}, "Test", "Test mail");
                } else {
                    // The save operation failed
                    // You can handle the failure, log an error message, or perform other actions
                    System.out.println("Failed to save booking");
                }
            }
        }
    }

    private Booking createBookingFromTrackList(TrackList trackList) {
        // Create a new Booking object and set its properties based on the tracklist data
        Booking booking = new Booking();
        booking.setDate(new Date());
        booking.setShowTime("1030");
        booking.setSeats((Set<String>) Arrays.asList("A3"));
        booking.setPaid(false);
        booking.setLocation("YourLocation");
        // Set other properties based on the tracklist data
        return booking;
    }

}
