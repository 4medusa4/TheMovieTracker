package com.themovietracker.TheMovieTracker.helpers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.themovietracker.TheMovieTracker.enums.MovieSortType;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MovieSortTypeDeserializer extends JsonDeserializer<MovieSortType> {
    @Override
    public MovieSortType deserialize(@NotNull JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText().toUpperCase();
        for (MovieSortType sortType :
                MovieSortType.values()) {
            if (sortType.name().equals(value))
                return sortType;
        }
        throw new IllegalArgumentException("Invalid value for MovieSortType: " + value);
    }
}
