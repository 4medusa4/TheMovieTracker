package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.service.MovieService;
import com.themovietracker.TheMovieTracker.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TmdbService tmdbService;

    @GetMapping(path = "/api/v1/movies", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(this.movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovieTmdb")
    public ResponseEntity<String> getMovie(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(this.tmdbService.getMovieDetails(id), HttpStatus.OK);
    }
}
