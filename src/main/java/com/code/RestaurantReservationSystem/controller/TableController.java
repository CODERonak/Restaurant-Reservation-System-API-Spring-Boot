package com.code.RestaurantReservationSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Table.TableDTO;
import com.code.RestaurantReservationSystem.service.TableService;

@RestController
@RequestMapping("/tables")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTable(@RequestBody TableDTO request) {
        tableService.createTable(request);
        return new ResponseEntity<>("Table created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{tableId}")
    public ResponseEntity<String> updateTable(@PathVariable Long tableId, @RequestBody TableDTO request) {
        tableService.updateTable(tableId, request);
        return new ResponseEntity<>("Table updated successfully", HttpStatus.OK);
    }

}