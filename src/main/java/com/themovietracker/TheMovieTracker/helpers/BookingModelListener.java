package com.themovietracker.TheMovieTracker.helpers;

import com.themovietracker.TheMovieTracker.data.Booking;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingModelListener extends AbstractMongoEventListener<Booking> {
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(@NotNull BeforeConvertEvent<Booking> event) {
        if (event.getSource().getId() < 1)
            event.getSource().setId(sequenceGenerator.generateSequence(Booking.SEQUENCE_NAME));
    }
}
