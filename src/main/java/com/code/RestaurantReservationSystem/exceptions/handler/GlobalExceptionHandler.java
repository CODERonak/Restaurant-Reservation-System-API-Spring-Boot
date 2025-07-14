package com.code.RestaurantReservationSystem.exceptions.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.RestaurantReservationSystem.exceptions.custom.authentication.*;
import com.code.RestaurantReservationSystem.exceptions.custom.restaurant.RestaurantAlreadyExistsException;
import com.code.RestaurantReservationSystem.exceptions.payload.ErrorResponse;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// This class is used to handle exceptions
@RestControllerAdvice
public class GlobalExceptionHandler {

    // this method handles the exception if the email or username already exists
    @ExceptionHandler(EmailOrUsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailOrUsernameAlreadyExistsException(
            EmailOrUsernameAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // this method handles the exception if the username or password is invalid
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentialsExceptions(
        InvalidCredentialsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    // this method handles the exception if the restaurant already exists
    @ExceptionHandler(RestaurantAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantAlreadyExistsException(
            RestaurantAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}