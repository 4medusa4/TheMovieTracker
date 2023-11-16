package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

}
