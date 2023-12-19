package com.themovietracker.TheMovieTracker.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/api/v1/user")
public class UserController {

    private final UserService service;

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserByID(@PathVariable long id) {
        return service.getUserByID(id);
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping(path = "/users/{id}")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUser(@PathVariable long id) {
        service.deleteUser(id);
    }

    @PatchMapping(path = "/password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/logout")
    public void logout() {
        System.out.println("User logged out");
    }
}
