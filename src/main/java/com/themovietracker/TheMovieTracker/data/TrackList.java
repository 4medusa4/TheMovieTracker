package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "TrackList")
public class TrackList {
    @Transient
    public static final String SEQUENCE_NAME = "SQN_TRACKLIST";
    @Id
    private long id;
    private Date currentDate;
    private Date bookedDate;
    private String partOfTheDay;
    private int numberOfSeats;
    private String arrangement;
    private boolean autoBooking;
    private long movieId;
    private int theatreId;
}
