package com.themovietracker.TheMovieTracker.tmdb;

import com.themovietracker.TheMovieTracker.data.MovieParams;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TmdbService {

    @Value(value = "${application.api.tmdb.base_url}")
    private String baseUrl;

    @Value(value = "${application.api.tmdb.key}")
    private String apiKey;

    @Value(value = "${application.api.tmdb.image.base_url}")
    private String baseUrlForImages;

    private final RestTemplate restTemplate;

    public String getMovie(long movieId) {
        String url = baseUrl + "/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovies(@NotNull MovieParams movieParams) {
        String url = baseUrl + "/discover/movie?api_key=" + apiKey
                + "&certification_country=" + movieParams.getCertificationCountry()
                + "&page=" + movieParams.getPage() + "&show_me=" + movieParams.getShowMe()
                + "&sort_by=" + movieParams.getSortBy().name().toLowerCase() + ".desc"
                + "&watch_region=" + movieParams.getWatchRegion()
                + "&with_original_language=" + movieParams.getWithOriginalLanguage()
                + "&with_runtime.lte=" + movieParams.getWithRuntimeLte();
        return restTemplate.getForObject(url, String.class);
    }

    public String getLanguages() {
        String url = baseUrl
                + "/configuration/languages?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getCountries(String language) {
        String url = baseUrl
                + "/configuration/countries?language=" + language + "&api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getImageUrl(String imageName) {
        return baseUrlForImages + "/" + imageName + ".png";
    }


    public String getRecommendedMovies(long id) {
        String url = baseUrl
                + "/movie/" + id + "/lists?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getNewTmdbToken() {
        String url = baseUrl
                + "/authentication/token/new?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String createSession(String requestToken) {
        String url = baseUrl
                + "/authentication/session/new?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class, requestToken);
    }
}
