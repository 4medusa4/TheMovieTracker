package com.themovietracker.TheMovieTracker.controller;

import com.themovietracker.TheMovieTracker.data.TrackList;
import com.themovietracker.TheMovieTracker.service.TrackListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/track-list")
public class TrackListController {
    private final TrackListService tracklistService;
    @GetMapping("/all")
    public ResponseEntity<List<TrackList>> getAllTrackList(){
        return new ResponseEntity<List<TrackList>>(tracklistService.getAllTrackList(), HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, name = "addToTrackList")
    public ResponseEntity<TrackList> addToTrackList(@RequestBody TrackList tracklist) {
        return ResponseEntity.ok(tracklistService.addToTrackList(tracklist));
    }
}
