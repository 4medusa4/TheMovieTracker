package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(this.movieService.getMovies(), HttpStatus.OK);
    }
}
