package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Tracklist;
import com.themovietracker.TheMovieTracker.repository.TracklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@Service
public class TracklistService {
    @Autowired
    private TracklistRepository tracklistRepository;
    private Queue<Tracklist> autoBookingQueue = new LinkedList<>();


    public List<Tracklist> getAllTrackList(){
        return tracklistRepository.findAll();
    }
    public Optional<Tracklist> getTracklistById(int id) {
        return this.tracklistRepository.findById(id);
    }

    public void processAutoBookingQueue() {
        while (!autoBookingQueue.isEmpty()) {
            Tracklist tracklist = autoBookingQueue.poll();
            bookTicket(tracklist);
        }
    }

    public void addToAutoBookingQueue() {
        List<Tracklist> tracklists = getAllTrackList();

        for (Tracklist tracklist : tracklists) {
            if (tracklist.isAutoBooking()) {
                autoBookingQueue.offer(tracklist);
            }
        }
    }

    private void bookTicket(Tracklist tracklist) {
        // Implement your ticket booking logic here
        // For example, update the bookedDate, set status, etc.
        tracklist.setBookedDate(LocalDate.now());
        tracklistRepository.save(tracklist);
    }


}
