package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.config.TmdbConfiguration;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbService {

    private final TmdbConfiguration tmdbConfiguration;

    private final RestTemplate restTemplate;

    @Autowired
    public TmdbService(RestTemplate restTemplate, TmdbConfiguration tmdbConfiguration) {
        this.restTemplate = restTemplate;
        this.tmdbConfiguration = tmdbConfiguration;
    }

    public String getMovieDetails(long movieId) {
        String url = tmdbConfiguration.getBaseUrl() + "/movie/" + movieId + "?api_key=" + tmdbConfiguration.getKey();
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovies(int pageNo, @NotNull String language) {
        String url = tmdbConfiguration.getBaseUrl()
                + "/discover/movie/?api_key=" + tmdbConfiguration.getKey()
                + "certification_country=" + language.split("-")[1]
                + "&page=" + pageNo + "&show_me=0&sort_by=popularity.desc&watch_region=LK&with_original_language=si&with_runtime.lte=400";
        return restTemplate.getForObject(url, String.class);
    }

}
