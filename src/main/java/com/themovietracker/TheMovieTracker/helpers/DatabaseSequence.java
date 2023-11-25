package com.themovietracker.TheMovieTracker.helpers;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "database_sequence")
public class DatabaseSequence {
    @Id
    private String id;
    private long sequence;
}
