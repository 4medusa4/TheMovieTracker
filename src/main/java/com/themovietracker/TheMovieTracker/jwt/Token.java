package com.themovietracker.TheMovieTracker.jwt;

import com.themovietracker.TheMovieTracker.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Arrays;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Token")
public class Token {
    @Transient
    public static final String SEQUENCE_NAME = "SQN_JWT";
    @Id
    private long id;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private boolean revoked;
    private boolean expired;
    private User user;
}
