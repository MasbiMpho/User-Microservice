package com.autosyn.userservice.controller;

import com.autosyn.userservice.dto.UserRequest;
import com.autosyn.userservice.model.User;
import com.autosyn.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.registerUser(userRequest);
        return ResponseEntity.ok(user);
    }
}
