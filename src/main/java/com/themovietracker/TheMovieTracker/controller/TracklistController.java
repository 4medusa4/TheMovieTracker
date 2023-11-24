package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.Tracklist;
import com.themovietracker.TheMovieTracker.service.TracklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TracklistController {
    @Autowired
    private TracklistService tracklistService;
    @RequestMapping("/api/vi/tracklist")
    public ResponseEntity<List<Tracklist>> getAllTrackList(){
        return new ResponseEntity<List<Tracklist>>(tracklistService.getAllTrackList(), HttpStatus.OK);
    }
}
