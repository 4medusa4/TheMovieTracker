package com.themovietracker.TheMovieTracker.helpers;

import com.themovietracker.TheMovieTracker.data.TrackList;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TracklistModelListener extends AbstractMongoEventListener<TrackList> {
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(@NotNull BeforeConvertEvent<TrackList> event) {
        if (event.getSource().getId() < 1)
            event.getSource().setId(sequenceGenerator.generateSequence(TrackList.SEQUENCE_NAME));
    }
}
