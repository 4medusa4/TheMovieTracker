package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        Optional<Movie> optMovie = this.movieRepository.getMovieById(id);
        if (optMovie.isEmpty()) {
            throw new IllegalArgumentException("Movie not found.");
        }
        return optMovie;
    }
}
