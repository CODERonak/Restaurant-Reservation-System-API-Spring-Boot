package com.code.RestaurantReservationSystem.exceptions.custom.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This exception is thrown when a restaurant with the same name already exists
@ResponseStatus(HttpStatus.CONFLICT)
public class RestaurantAlreadyExistsException extends RuntimeException {
    public RestaurantAlreadyExistsException(String message) {
        super(message);
    }
}