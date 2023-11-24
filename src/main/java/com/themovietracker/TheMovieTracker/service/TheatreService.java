package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Theatre;
import com.themovietracker.TheMovieTracker.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public List<Theatre> getAllTheaters() {
        List<Theatre> theatres = theatreRepository.findAll();
        return theatres;
    }

    public Theatre getTheaterByID(String theaterId) {
        Optional<Theatre> theater = theatreRepository.findById(theaterId);
        return theater.get();
    }

    public Theatre createTheater(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre updateTheater(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public void deleteTheater(String id) {
        theatreRepository.deleteById(id);
    }

    public Optional<Theatre> getTheatreById(String theatreId) {
        return null;
    }
}
