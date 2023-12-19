package com.themovietracker.TheMovieTracker.user;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public void changePassword(@NotNull ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the tow new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationText())) {
            throw new IllegalStateException("Passwords are not the same");
        }
        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserByID(long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow();
    }
}