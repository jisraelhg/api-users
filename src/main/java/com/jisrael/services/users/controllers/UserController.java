package com.jisrael.services.users.controllers;

import com.jisrael.services.users.entity.User;
import com.jisrael.services.users.model.NewUserRequest;
import com.jisrael.services.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUsers(@PathVariable String userId) {
        User user = userService.getUserId(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody NewUserRequest request) {
        User user = userService.createUser(request);
        return ResponseEntity.ok(user);
    }
}
