package com.themovietracker.TheMovieTracker.service;

import com.themovietracker.TheMovieTracker.data.User;
import com.themovietracker.TheMovieTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> user=userRepository.findAll();
        return user;
    }
    public User getUserByID(String userId){
        Optional<User> user=userRepository.findById(userId);
        return user.get();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
