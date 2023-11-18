package com.themovietracker.TheMovieTracker.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "tmdb.api")
public class TmdbConfiguration {

    private String key;

    private String baseUrl;
}
