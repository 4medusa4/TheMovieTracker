package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Theatre;
import com.themovietracker.TheMovieTracker.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @GetMapping(path = "/theaters")
    public List<Theatre> getAllTheaters() {
        return theatreService.getAllTheaters();
    }

    @GetMapping(path = "/theaters/{id}")
    public Theatre getTheaterByID(@PathVariable String id) {
        return theatreService.getTheaterByID(id);
    }

    @PostMapping(path = "/theaters")
    public Theatre createTheater(@RequestBody Theatre theatre) {
        return theatreService.createTheater(theatre);
    }

    @PutMapping(path = "/theaters/{id}")
    public Theatre updateTheater(@RequestBody Theatre theatre) {
        return theatreService.updateTheater(theatre);
    }

    @DeleteMapping(path = "theaters/{id}")
    public void deleteTheater(@PathVariable String id) {
        theatreService.deleteTheater(id);
    }
}
