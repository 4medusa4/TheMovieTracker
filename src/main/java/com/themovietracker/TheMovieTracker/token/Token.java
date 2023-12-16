package com.themovietracker.TheMovieTracker.token;

import com.themovietracker.TheMovieTracker.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Token")
public class Token {
    @Transient
    public static final String SEQUENCE_NAME = "token_sequence";
    @Id
    private long tid;
    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType tokenType = TokenType.BEARER;
    private boolean revoked;
    private boolean expired;
    private User user;
}
