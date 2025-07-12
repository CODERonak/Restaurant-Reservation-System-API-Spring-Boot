package com.code.RestaurantReservationSystem.exceptions.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.RestaurantReservationSystem.exceptions.custom.authentication.*;
import com.code.RestaurantReservationSystem.exceptions.custom.restaurant.RestaurantAlreadyExistsException;
import com.code.RestaurantReservationSystem.exceptions.payload.ErrorResponse;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailOrUsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailOrUsernameAlreadyExistsException(
            EmailOrUsernameAlreadyExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentialsExceptions(
        InvalidCredentialsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

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