package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Movie")
public class Movie {
    @Id
    @Column(name = "_id")
    private String _id;

    @Column(name = "adult")
    private boolean adult;

    @Column(name = "backdrop_path")
    private String backdropPath;

    @Column(name = "genre_ids")
    private int[] genreIds;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "overview")
    private String overview;

    @Column(name = "popularity")
    private double popularity;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "title")
    private String title;

    @Column(name = "video")
    private boolean video;

    @Column(name = "id")
    private Long id;

    @Column(name = "vote_average")
    private double voteAverage;

    @Column(name = "vote_count")
    private int voteCount;
}
