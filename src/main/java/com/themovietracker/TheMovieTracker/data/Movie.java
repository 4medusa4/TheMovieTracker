package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Movie")
public class Movie {
    @Transient
    public static final String SEQUENCE_NAME = "SQN_MOVIE";
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
    private boolean status;
    private int totalSeats;
    private int bookedSeats;
    private int availableSeats;
    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }
    @DocumentReference
    private List<Booking> bookingIds;
    @DocumentReference
    private List<TrackList> trackListIds;


}
