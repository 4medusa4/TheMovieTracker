package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.MovieParams;
import com.themovietracker.TheMovieTracker.tmdb.TmdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final TmdbService tmdbService;

    @PostMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovies")
    public ResponseEntity<String> getMovies(@RequestBody MovieParams movieParams) {
        return new ResponseEntity<>(this.tmdbService.getMovies(movieParams), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getMovieTmdb")
    public ResponseEntity<String> getMovieTmdb(@PathVariable(name = "id") long id) {

        return new ResponseEntity<>(this.tmdbService.getMovie(id), HttpStatus.OK);
    }

    @GetMapping(path = "/languages", produces = MediaType.APPLICATION_JSON_VALUE, name = "getLanguages")
    public ResponseEntity<String> getLanguagesTMDB() {
        return new ResponseEntity<>(this.tmdbService.getLanguages(), HttpStatus.OK);
    }

    @GetMapping(path = "/countries/{language}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getCountries")
    public ResponseEntity<String> getCountriesTMDB(@PathVariable(name = "language") String language) {
        return new ResponseEntity<>(this.tmdbService.getCountries(language), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/recommend", produces = MediaType.APPLICATION_JSON_VALUE, name = "getRecommendedMovies")
    public ResponseEntity<String> getRecommendedMovies(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(this.tmdbService.getRecommendedMovies(id), HttpStatus.OK);
    }

    @GetMapping(path = "/token/new", produces = MediaType.APPLICATION_JSON_VALUE, name = "getNewTmdbToken")
    public ResponseEntity<String> getNewTmdbToken() {
        return new ResponseEntity<>(this.tmdbService.getNewTmdbToken(), HttpStatus.OK);
    }

}
