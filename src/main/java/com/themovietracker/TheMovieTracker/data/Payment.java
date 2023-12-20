package com.themovietracker.TheMovieTracker.data;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Payments")
public class Payment {
    @Transient
    public static final String SEQUENCE_NAME = "SQN_PAYMENT";
    @Id
    private Long id;
    private Long amount;
    private Date paymentdate;
    private Time paymentTime;
}
