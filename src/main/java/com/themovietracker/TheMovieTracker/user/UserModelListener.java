package com.themovietracker.TheMovieTracker.user;

import com.themovietracker.TheMovieTracker.helpers.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

@RequiredArgsConstructor
public class UserModelListener extends AbstractMongoEventListener<User> {
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(@NotNull BeforeConvertEvent<User> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
        }
    }
}
