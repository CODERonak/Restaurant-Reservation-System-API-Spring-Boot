package com.code.RestaurantReservationSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Table.TableDTO;
import com.code.RestaurantReservationSystem.model.Tables;
import com.code.RestaurantReservationSystem.service.TableService;

// This controller is used to for Tables
@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    // It sends a post request to the server to create a new table
    @PostMapping("/create")
    public ResponseEntity<String> createTable(@RequestBody TableDTO request) {
        tableService.createTable(request);
        return new ResponseEntity<>("Table created successfully", HttpStatus.CREATED);
    }

    // It sends a put request to the server to update a table
    @PutMapping("/update/{tableId}")
    public ResponseEntity<String> updateTable(@PathVariable Long tableId, @RequestBody TableDTO request) {
        tableService.updateTable(tableId, request);
        return new ResponseEntity<>("Table updated successfully", HttpStatus.OK);
    }

    // It sends get request to the server to get all the tables
    @GetMapping("/getAll/{restaurantId}")
    public ResponseEntity<List<Tables>> getTablesByRestaurant(@PathVariable Long restaurantId) {
        List<Tables> tables = tableService.getTablesByRestaurant(restaurantId);
        tables.forEach(table -> table.getRestaurant().getId()); 
        return ResponseEntity.ok(tables);
    }
}