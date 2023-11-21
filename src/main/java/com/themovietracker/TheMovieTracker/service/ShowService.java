package com.themovietracker.TheMovieTracker.service;

import com.sun.istack.NotNull;
import com.themovietracker.TheMovieTracker.data.Show;
import com.themovietracker.TheMovieTracker.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShows() {
        return this.showRepository.findAll();
    }

    public Optional<Show> getShowById(int id) {
        Optional<Show> optShow = this.showRepository.getShowById(id);
        if (optShow.isEmpty()) {
            throw new IllegalArgumentException("Show not found.");
        }
        return optShow;
    }

    public Optional<Show> getShowByStartTime(Time startTime) {
        Optional<Show> optShow = this.showRepository.getShowByStartTime(startTime);
        if (optShow.isEmpty()) {
            throw new IllegalArgumentException("User not found.");
        }
        return optShow;
    }

    public long saveShow(Show show) {
        List<Show> existingList = this.showRepository.findAll();
        for (Show s : existingList) {
            if (Objects.equals(s.getStartTime(), show.getStartTime())) {
                throw new IllegalArgumentException("Show already saved");
            }
        }
        return this.showRepository.save(show).getId();
    }

    public List<Show> saveShows(@NotNull @org.jetbrains.annotations.NotNull List<Show> shows) {
        List<Show> duplicates = new ArrayList<>();
        for (var show : shows) {
            if (shows.stream().filter(s -> s.getStartTime().equals(show.getStartTime())).toList().size() > 1)
                duplicates.add(show);
        }
        shows.removeAll(duplicates);
        if (shows.isEmpty())
            throw new IllegalArgumentException("Duplicate data in the input found.");
        List<Show> existingList = this.showRepository.findAll();
        List<Show> removeList = new ArrayList<>();
        for (var show : shows) {
            removeList.addAll(existingList
                    .stream()
                    .filter(u ->
                            u.getStartTime().equals(show.getStartTime()))
                    .toList());
        }
        removeList.forEach(item -> {
            for (var show : existingList) {
                shows.removeIf(u -> u.getStartTime().equals(show.getStartTime()));
            }
        });
        existingList.clear();
        removeList.clear();
        if (!shows.isEmpty())
            return this.showRepository.saveAll(shows);
        throw new IllegalArgumentException("Show with given emails are found.");
    }

    public int updateShow(@NotNull @org.jetbrains.annotations.NotNull Show show) {
        Optional<Show> toBeUpdate = this.showRepository.getShowById(show.getId());
        if (toBeUpdate.isPresent()
                && !toBeUpdate.get().equals(show)) {
            this.showRepository.updateShow(show.getId(), show.getStartTime(), show.getTicketPrice());
            return show.getId();
        }
        return -1;
    }
}
