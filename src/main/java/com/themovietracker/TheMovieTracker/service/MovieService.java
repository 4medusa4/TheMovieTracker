package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.Movie;
import com.themovietracker.TheMovieTracker.repository.MovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        Optional<Movie> optMovie = this.movieRepository.getMovieById(id);
        if (optMovie.isEmpty()) {
            throw new IllegalArgumentException("Movie not found.");
        }
        return optMovie;
    }

    public void updateTrackListStatus(){
        List<Movie> movies = getMovies();
        LocalDate today = LocalDate.now();

        for (Movie movie : movies){
            LocalDate releaseDate = LocalDate.parse(movie.getReleaseDate());
            if(releaseDate !=  null && releaseDate.minusDays(3).equals(today)){
                movie.setStatus(true);
                movieRepository.save(movie);
            }
        }
    }
}
