package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.TrackList;
import com.themovietracker.TheMovieTracker.repository.TrackListRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TrackListService {
    private final TrackListRepository tracklistRepository;
    private final Queue<TrackList> autoBookingQueue = new LinkedList<>();


    public List<TrackList> getAllTrackList() {
        return tracklistRepository.findAll();
    }

    public Optional<TrackList> getTrackListById(int id) {
        return this.tracklistRepository.findById(id);
    }

    public void processAutoBookingQueue() {
        while (!autoBookingQueue.isEmpty()) {
            TrackList tracklist = autoBookingQueue.poll();
            bookTicket(tracklist);
        }
    }

    public void addToAutoBookingQueue() {
        List<TrackList> trackLists = getAllTrackList();

        for (TrackList tracklist : trackLists) {
            if (tracklist.isAutoBooking()) {
                autoBookingQueue.offer(tracklist);
            }
        }
    }

    private void bookTicket(@NotNull TrackList tracklist) {
        // Implement your ticket booking logic here
        // For example, update the bookedDate, set status, etc.
        tracklist.setBookedDate(new Date(System.currentTimeMillis()));
        tracklistRepository.save(tracklist);
    }


    public TrackList addToTrackList(@NotNull TrackList tracklist) {
        return tracklistRepository.save(tracklist);
    }
}
