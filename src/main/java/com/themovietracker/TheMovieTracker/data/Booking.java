package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Booking")
public class Booking {

    @Transient
    public static final String SEQUENCE_NAME = "booking_sequence";
    @Id
    private long id;
    private Date date;
    private String showTime;
    private Set<String> seats;
    private boolean isPaid;
    private String location;

    @DocumentReference(collection = "Movie")
    private List<Movie> movieIds;
    @DocumentReference(collection = "Theatre")
    private List<Theatre> theatreIds;
    @DocumentReference(collection = "User")
    private List<User> userIds;
}
