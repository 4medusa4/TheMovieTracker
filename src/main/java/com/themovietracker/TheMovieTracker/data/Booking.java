package com.themovietracker.TheMovieTracker.data;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import com.themovietracker.TheMovieTracker.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Booking")
public class Booking {

    @Transient
    public static final String SEQUENCE_NAME = "SQN_BOOKING";
    @Id
    private long id;
    private Date date;
    private String showTime;
    private Set<String> seats;
    private boolean isPaid;
    private String location;
    private long movieId;
    @DocumentReference(collection = "Movie")
    private List<Movie> movieIds;
    @DocumentReference(collection = "Theatre")
    private List<Theatre> theatreIds;
    @DocumentReference(collection = "User")
    private List<User> userIds;
}
