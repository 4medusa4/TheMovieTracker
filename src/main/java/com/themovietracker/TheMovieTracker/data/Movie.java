package com.themovietracker.TheMovieTracker.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;
@Document(collection = "Movie")
public class Movie {

    @Id
    private String id;
    private String title;
    private LocalDate releaseDate;
    private String directorName;
    private String actor;
    private String actress;
    private String trailerLink;
    private String description;
    private byte[] image;
}
