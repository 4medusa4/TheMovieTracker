package com.themovietracker.TheMovieTracker;

import com.themovietracker.TheMovieTracker.config.TmdbConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TmdbConfiguration.class)
public class TheMovieTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheMovieTrackerApplication.class, args);
	}

}
