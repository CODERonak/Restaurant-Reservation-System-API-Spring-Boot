package com.code.RestaurantReservationSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.code.RestaurantReservationSystem.dto.Table.AvailabilityDTO;
import com.code.RestaurantReservationSystem.service.AvailabilityService;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @PostMapping("/add/{restaurantId}")
    public ResponseEntity<String> createAvailability(@RequestBody AvailabilityDTO available,
            @PathVariable Long restaurantId) {
        availabilityService.createAvailability(available, restaurantId);
        return new ResponseEntity<>("Availability created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{availabilityId}")
    public ResponseEntity<String> updateAvailability(@RequestBody AvailabilityDTO available,
            @PathVariable Long availabilityId) {
        availabilityService.updateAvailability(available, availabilityId);
        return new ResponseEntity<>("Availability updated successfully", HttpStatus.OK);
    }

}