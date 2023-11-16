package com.themovietracker.TheMovieTracker.controller;

import com.sun.istack.NotNull;
import com.themovietracker.TheMovieTracker.data.Show;
import com.themovietracker.TheMovieTracker.repository.ShowRepository;
import com.themovietracker.TheMovieTracker.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
@RestController
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping(path = "/api/v1/shows", produces = MediaType.APPLICATION_JSON_VALUE, name = "getShows")
    public ResponseEntity<List<Show>> getShows() {
        return new ResponseEntity<>(this.showService.getShows(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/show", produces = MediaType.APPLICATION_JSON_VALUE, name = "getShowById", params = "id")
    public ResponseEntity<Show> getShow(@RequestParam int id) {
        return new ResponseEntity<>(this.showService.getShowById(id).stream().iterator().next(), HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/show", produces = MediaType.APPLICATION_JSON_VALUE, name = "getShowByName", params = "name")
    public ResponseEntity<Show> getShowByStartTime(@RequestParam Time startTime) {
        return new ResponseEntity<>(this.showService.getShowByStartTime(startTime).stream().iterator().next(), HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/show", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveShow(@RequestBody @NotNull Show show) {
        return new ResponseEntity<>(this.showService.saveShow(show), HttpStatus.OK);
    }

    @PostMapping(path = "/api/v1/shows", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Integer>> saveShows(@RequestBody @NotNull List<Show> shows) {
        return new ResponseEntity<>(this.showService.saveShows(shows).stream().map(Show::getId).toList(), HttpStatus.OK);
    }

    @PutMapping(path = "/api/v1/show", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateShow(@RequestBody @NotNull Show show) {
        return new ResponseEntity<>(this.showService.updateShow(show), HttpStatus.OK);
    }

//    @PutMapping(path = "/api/v1/shows", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Integer>> updateShows(@RequestBody @NotNull List<Show> shows) {
//        return new ResponseEntity<>(Arrays.stream(this.showService.batchUpdate(shows)).boxed().toList(), HttpStatus.OK);
//    }
}
