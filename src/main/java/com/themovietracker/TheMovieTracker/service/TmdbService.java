package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.config.TmdbConfiguration;
import com.themovietracker.TheMovieTracker.data.MovieParams;
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

    public String getMovie(long movieId) {
        String url = tmdbConfiguration.getBaseUrl() + "/movie/" + movieId + "?api_key=" + tmdbConfiguration.getKey();
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovies(@NotNull MovieParams movieParams) {
        String url = tmdbConfiguration.getBaseUrl() + "/discover/movie?api_key=" + tmdbConfiguration.getKey()
                + "&certification_country=" + movieParams.getCertificationCountry()
                + "&page=" + movieParams.getPage() + "&show_me=" + movieParams.getShowMe()
                + "&sort_by=" + movieParams.getSortBy().name().toLowerCase() + ".desc"
                + "&watch_region=" + movieParams.getWatchRegion()
                + "&with_original_language=" + movieParams.getWithOriginalLanguage()
                + "&with_runtime.lte=" + movieParams.getWithRuntimeLte();
        return restTemplate.getForObject(url, String.class);
    }

    public String getLanguages() {
        String url = tmdbConfiguration.getBaseUrl()
                + "/configuration/languages?api_key=" + tmdbConfiguration.getKey();
        return restTemplate.getForObject(url, String.class);
    }

    public String getCountries(String language) {
        String url = tmdbConfiguration.getBaseUrl()
                + "/configuration/countries?language=" + language + "&api_key=" + tmdbConfiguration.getKey();
        return restTemplate.getForObject(url, String.class);
    }

    public String getImageUrl(String imageName) {
        return tmdbConfiguration.getBaseUrlForImage() + "/" + imageName + ".png";
    }


}
