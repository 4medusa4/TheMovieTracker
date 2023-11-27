package com.themovietracker.TheMovieTracker.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.themovietracker.TheMovieTracker.enums.MovieSortType;
import com.themovietracker.TheMovieTracker.helpers.MovieSortTypeDeserializer;
import lombok.Data;

import java.util.Date;

@Data
public class MovieParams {
    private boolean includeAdult;
    private boolean includeVideo;
    private Date airDateGte;
    private Date airDateLte;
    private String certification;
    private String certificationCountry;
    private boolean debug;
    private Date firstAirDateGte;
    private Date firstAirDateLte;
    private int page;
    private Date primaryReleaseDateGte;
    private Date primaryReleaseDateLte;
    private String region;
    private Date releaseDateGte;
    private Date releaseDateLte;
    private int showMe;
    @JsonDeserialize(using = MovieSortTypeDeserializer.class)
    private MovieSortType sortBy;
    private double voteAverageGte;
    private double voteAverageLte;
    private int voteCountGte;
    private String watchRegion;
    private String withGenres;
    private String withKeywords;
    private String withNetworks;
    private String withOriginCountry;
    private String withOriginalLanguage;
    private String withWatchMonetizationTypes;
    private String withWatchProviders;
    private String withReleaseType;
    private int withRuntimeGte;
    private int withRuntimeLte;
}
