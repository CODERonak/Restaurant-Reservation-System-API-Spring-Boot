package com.code.RestaurantReservationSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Restaurant.RestuarantRequestDTO;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.service.RestaurantService;

@RestController
@RequestMapping("/admin/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRestaurant(@RequestBody RestuarantRequestDTO request) {
        restaurantService.createRestaurant(request);
        return new ResponseEntity<>("Restaurant created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<String> updateRestaurant(@PathVariable Long restaurantId,
            @RequestBody RestuarantRequestDTO request) {
        restaurantService.updateRestaurantDetails(restaurantId, request);
        return new ResponseEntity<>("Restaurant updated successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return new ResponseEntity<>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

}