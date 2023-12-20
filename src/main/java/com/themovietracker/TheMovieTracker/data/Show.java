package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Show")
public class Show {
    @Transient
    public static final String SEQUENCE_NAME = "SQN_SHOW";
    @Id
    private int id;
    private Time startTime;
    private double ticketPrice;
}
