package com.themovietracker.TheMovieTracker.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "Genre")
public class Genre {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
