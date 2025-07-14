package com.code.RestaurantReservationSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Auth.*;
import com.code.RestaurantReservationSystem.service.AuthService;

// This class is used to for Authentication
@RestController
@RequestMapping("/auth")
public class AuthController {

    // defining the auth service
    private final AuthService authService;

    // implementing the constructor injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // It sends a post request to the server to register a new user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO request) {
        authService.registerUser(request);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    // this method sends a post request to the server to login a user which if successfull returns the token
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO request) {
        String token = authService.loginUser(request);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}