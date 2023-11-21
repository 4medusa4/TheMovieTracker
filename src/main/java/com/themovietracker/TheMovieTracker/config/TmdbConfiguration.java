package com.themovietracker.TheMovieTracker.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tmdb.api")
public class TmdbConfiguration {
    private String key;
    private String baseUrl;
    private String baseUrlForImage;
}
