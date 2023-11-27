package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private String partOfTheDay;
    private int numberOfSeats;
    private String arrangement;
    private boolean autoBooking;
    private int movieId;
    private int theatreId;

    public String toString() {
        return "Tracking{" +
                "id='" + id + '\'' +
                ", theatreId='" + theatreId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", currentDate=" + LocalDate.now() +
                ", currentTime=" + LocalTime.now() +
                ", bookedDate=" + bookedDate +
                ", partOfTheDay='" + partOfTheDay + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", arrangement='" + arrangement + '\'' +
                ", autoBooking=" + autoBooking +
                '}';
    }


}
