package com.code.RestaurantReservationSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Restaurant.RestuarantRequestDTO;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.service.RestaurantService;

// this controller is used to send the requests to the server
@RestController
@RequestMapping("/admin/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // this method creates a restaurant in the database
    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody RestuarantRequestDTO request) {
        restaurantService.createRestaurant(request);
        // throws response if successful
        return new ResponseEntity<>("Restaurant created successfully", HttpStatus.CREATED);
    }

    // this method updates the restaurant in the database
    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long restaurantId,
            @RequestBody RestuarantRequestDTO request) {
        restaurantService.updateRestaurantDetails(restaurantId, request);
        return new ResponseEntity<>("Restaurant updated successfully", HttpStatus.OK);
    }

    // this method get all the restaurants from the database
    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

}