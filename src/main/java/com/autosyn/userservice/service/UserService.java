package com.autosyn.userservice.service;

import com.autosyn.userservice.dto.UserRequest;
import com.autosyn.userservice.model.User;
import com.autosyn.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword()); // Note: Add hashing later!

        return userRepository.save(user);
    }
}
