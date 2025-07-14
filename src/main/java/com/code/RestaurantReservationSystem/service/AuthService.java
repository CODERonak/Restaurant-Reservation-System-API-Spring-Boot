package com.code.RestaurantReservationSystem.service;

import com.code.RestaurantReservationSystem.dto.Auth.*;
import com.code.RestaurantReservationSystem.exceptions.custom.authentication.*;
import com.code.RestaurantReservationSystem.jwt.JWTUtil;
import com.code.RestaurantReservationSystem.model.Users;
import com.code.RestaurantReservationSystem.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // creating the fields 
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    // constructor injection
    public AuthService(UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder,
            JWTUtil jwtUtil,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    // this method returns register the user in the database
    public void registerUser(RegisterRequestDTO request) {
        // throws exception if the username and email already exists
        if (userRepository.existsByUsername(request.getUsername())
                || userRepository.existsByEmail(request.getEmail())) {
            throw new EmailOrUsernameAlreadyExistsException("Email or Username Already exists!");
        }

        // create's user object and saves it in the database
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

    // login's the user and returns the token
    public String loginUser(LoginRequestDTO request) {
        // this tries to authenticate the user and returns the token if successful
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            String username = authentication.getName();

            return jwtUtil.generateToken(username);
        } catch (Exception e) {
            // if unsuccessful throws exception
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}
