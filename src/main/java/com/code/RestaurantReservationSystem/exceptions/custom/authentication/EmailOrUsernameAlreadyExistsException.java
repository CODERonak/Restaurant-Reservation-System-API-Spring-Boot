package com.code.RestaurantReservationSystem.exceptions.custom.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This exception is thrown when an email or username already exists
@ResponseStatus(HttpStatus.CONFLICT)
public class EmailOrUsernameAlreadyExistsException extends RuntimeException {
    public EmailOrUsernameAlreadyExistsException(String message) {
        super(message);
    }
}