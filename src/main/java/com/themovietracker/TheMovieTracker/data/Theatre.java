package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Transient;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Theatre")
public class Theatre {

    @Transient
    public static final String SEQUENCE_NAME = "SQN_THEATRE";
    @Id
    private String theater_id;
    private String theater_name;
    private String location;
    private int no_of_seats;
    private int totalSeats;
    private int bookedSeats;
    private int availableSeats;
    @DocumentReference
    private List<Booking> bookingIds;
    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

}
