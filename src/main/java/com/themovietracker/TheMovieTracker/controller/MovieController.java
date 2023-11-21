package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.MovieParams;
import com.themovietracker.TheMovieTracker.service.MovieService;
import com.themovietracker.TheMovieTracker.service.TmdbService;
import com.themovietracker.TheMovieTracker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TmdbService tmdbService;
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/api/v1/tmdb/movies", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovies")
    public ResponseEntity<String> getMovies(@RequestHeader(name = "token_key") String token, @RequestBody MovieParams movieParams) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getMovies(movieParams), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(path = "api/v1/tmdb/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovieTmdb")
    public ResponseEntity<String> getMovieTmdb(@RequestHeader(name = "token_key") String token, @PathVariable(name = "id") long id) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getMovie(id), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(path = "api/v1/tmdb/movie/languages", produces = MediaType.APPLICATION_JSON_VALUE, name = "getLanguages")
    public ResponseEntity<String> getLanguagesTMDB(@RequestHeader(name = "token_key") String token) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getLanguages(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(path = "api/v1/tmdb/movie/countries/{language}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getCountries")
    public ResponseEntity<String> getCountriesTMDB(@RequestHeader(name = "token_key") String token, @PathVariable(name = "language") String language) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getCountries(language), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(path = "api/v1/tmdb/movie/{id}/recommend", produces = MediaType.APPLICATION_JSON_VALUE, name = "getRecommendedMovies")
    public ResponseEntity<String> getRecommendedMovies(@RequestHeader(name = "token_key") String token, @PathVariable(name = "id") long id) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getRecommendedMovies(id), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(path = "api/v1/tmdb/token/new", produces = MediaType.APPLICATION_JSON_VALUE, name = "getNewTmdbToken")
    public ResponseEntity<String> getNewTmdbToken(@RequestHeader(name = "token_key") String token) {
        if (authService.validateToken(token)) {
            return new ResponseEntity<>(this.tmdbService.getNewTmdbToken(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
