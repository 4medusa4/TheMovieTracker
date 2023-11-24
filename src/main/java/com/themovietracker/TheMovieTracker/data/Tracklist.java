package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TrackList")
public class Tracklist {
    @Id
    private int id;
    private LocalDate currentDate;
    private Time currentTime;
    private LocalDate bookedDate;
    private String datesOfConvenience;
    private String partOfTheDay;
    private int numberOfSeats;
    private int numberOfFullSeats;
    private int numberOfHalfSeats;
    private String Arrangement;
    private boolean autoBooking;


}
