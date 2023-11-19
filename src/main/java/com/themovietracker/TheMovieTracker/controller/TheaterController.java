package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Theater;
import com.themovietracker.TheMovieTracker.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping(path = "/theaters")
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping(path = "/theaters/{id}")
    public Theater getTheaterByID(@PathVariable String id) {
        return theaterService.getTheaterByID(id);
    }

    @PostMapping(path = "/theaters")
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.createTheater(theater);
    }

    @PutMapping(path = "/theaters/{id}")
    public Theater updateTheater(@RequestBody Theater theater) {
        return theaterService.updateTheater(theater);
    }

    @DeleteMapping(path = "theaters/{id}")
    public void deleteTheater(@PathVariable String id) {
        theaterService.deleteTheater(id);
    }
}
