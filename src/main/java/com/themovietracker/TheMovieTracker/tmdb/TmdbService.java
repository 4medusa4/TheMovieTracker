package com.themovietracker.TheMovieTracker.tmdb;

import com.themovietracker.TheMovieTracker.data.MovieParams;
import com.themovietracker.TheMovieTracker.enums.MovieSortType;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TmdbService {

    private final RestTemplate restTemplate;
    @Value(value = "${application.api.tmdb.base_url}")
    private String baseUrl;
    @Value(value = "${application.api.tmdb.key}")
    private String apiKey;
    @Value(value = "${application.api.tmdb.image.base_url}")
    private String baseUrlForImages;

    public String getMovie(long movieId) {
        String url = baseUrl + "/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public String getMovies(@NotNull MovieParams movieParams) {
        StringBuilder url = new StringBuilder(baseUrl + "/discover/movie?api_key=" + apiKey);
        Class<?> clazz = movieParams.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(movieParams);
                if (value != null && (!(value instanceof String)
                        || !((String) value).isEmpty()) && (!(value instanceof Number)
                        || ((Number) value).intValue() != 0)) {

                    if (value instanceof Date date) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        value = format.format(date);
                    }
                    if (value instanceof MovieSortType movieSortType)
                        value = movieSortType.name().toLowerCase() + ".desc";

                    String formattedFieldName = getFormattedFieldName(field);
                    url.append("&").append(formattedFieldName).append("=").append(value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return restTemplate.getForObject(new String(url), String.class);
    }

    @Contract(pure = true)
    private @NotNull String getFormattedFieldName(@NotNull Field field) {
        String fieldName = field.getName();
        var postfixes = Set.of("Gte", "Lte");
        for (String postfix : postfixes)
            fieldName = fieldName.endsWith(postfix) ? fieldName.replaceAll(postfix, "." + postfix.toLowerCase()) : fieldName;
        return fieldName.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
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
