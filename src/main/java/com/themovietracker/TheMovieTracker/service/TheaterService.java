package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Theater;
import com.themovietracker.TheMovieTracker.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheaters(){
        List<Theater> theaters=theaterRepository.findAll();
        return theaters;
    }
    public Theater getTheaterByID(String theaterId){
        Optional<Theater> theater=theaterRepository.findById(theaterId);
        return theater.get();
    }
    public Theater createTheater(Theater theater){
        return theaterRepository.save(theater);
    }

    public Theater updateTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public void deleteTheater(String id) {
        theaterRepository.deleteById(id);
    }

}
