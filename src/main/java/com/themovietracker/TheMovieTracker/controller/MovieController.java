package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.MovieParams;
import com.themovietracker.TheMovieTracker.service.AuthService;
import com.themovietracker.TheMovieTracker.service.MovieService;
import com.themovietracker.TheMovieTracker.tmdb.TmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private TmdbService tmdbService;
    @Autowired
    private AuthService authService;

    @PostMapping(path = "/api/v1/tmdb/movies", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovies")
    public ResponseEntity<String> getMovies(@RequestBody MovieParams movieParams) {
        return new ResponseEntity<>(this.tmdbService.getMovies(movieParams), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovieTmdb")
    public ResponseEntity<String> getMovieTmdb(@PathVariable(name = "id") long id) {

        return new ResponseEntity<>(this.tmdbService.getMovie(id), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/movie/languages", produces = MediaType.APPLICATION_JSON_VALUE, name = "getLanguages")
    public ResponseEntity<String> getLanguagesTMDB() {
        return new ResponseEntity<>(this.tmdbService.getLanguages(), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/movie/countries/{language}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getCountries")
    public ResponseEntity<String> getCountriesTMDB(@PathVariable(name = "language") String language) {
        return new ResponseEntity<>(this.tmdbService.getCountries(language), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/movie/{id}/recommend", produces = MediaType.APPLICATION_JSON_VALUE, name = "getRecommendedMovies")
    public ResponseEntity<String> getRecommendedMovies(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(this.tmdbService.getRecommendedMovies(id), HttpStatus.OK);
    }

    @GetMapping(path = "api/v1/tmdb/token/new", produces = MediaType.APPLICATION_JSON_VALUE, name = "getNewTmdbToken")
    public ResponseEntity<String> getNewTmdbToken() {
        return new ResponseEntity<>(this.tmdbService.getNewTmdbToken(), HttpStatus.OK);
    }

}
