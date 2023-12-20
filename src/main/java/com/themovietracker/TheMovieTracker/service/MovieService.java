package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.data.Theatre;
import com.themovietracker.TheMovieTracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Movie id) {
        Optional<Movie> optMovie = this.movieRepository.getMovieById(id.getVoteCount());
        if (optMovie.isEmpty()) {
            throw new IllegalArgumentException("Movie not found.");
        }
        return optMovie;
    }

    public void updateTrackListStatus(){
        List<Movie> movies = getMovies();
        LocalDate today = LocalDate.now();

        for (Movie movie : movies){
            LocalDate releaseDate = LocalDate.parse(movie.getReleaseDate());
            if(releaseDate.minusDays(3).equals(today)){
                movie.setStatus(true);
                movieRepository.save(movie);
            }
        }
    }

    public void bookSeats(Movie movie, int numberOfSeats) {
        int availableSeats = movie.getAvailableSeats();
        if (availableSeats >= numberOfSeats) {
            movie.setAvailableSeats(availableSeats - numberOfSeats);
            movieRepository.save(movie);
        } else {
            // Handle the case where there are not enough available seats
            throw new IllegalArgumentException("Not enough available seats in the theatre.");
        }
    }
}
