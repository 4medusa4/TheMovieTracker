package com.themovietracker.TheMovieTracker.listeners;

import com.themovietracker.TheMovieTracker.helpers.SequenceGeneratorService;
import com.themovietracker.TheMovieTracker.jwt.Token;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenModelListener extends AbstractMongoEventListener<Token> {

    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(@NotNull BeforeConvertEvent<Token> event) {
        if (event.getSource().getId() < 1)
            event.getSource().setId(sequenceGenerator.generateSequence(Token.SEQUENCE_NAME));
    }
}