package com.code.RestaurantReservationSystem.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Auth.RegisterRequest;
import com.code.RestaurantReservationSystem.model.Users;
import com.code.RestaurantReservationSystem.repository.UserRepository;

// This class is used to register a new user
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // This method is used to register a new user
    // It takes a RegisterRequest object as a parameter and saves the user to the database
    // If the username or email already exists, it throws a RuntimeException

    public void registerUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("email already exists");
        }

        // If the username and email do not exist, the user is saved to the database
        // The password is encoded using the BCryptPasswordEncoder
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(request.getRole());

        userRepository.save(user);
    }
}