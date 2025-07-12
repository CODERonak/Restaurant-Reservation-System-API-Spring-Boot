package com.code.RestaurantReservationSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Table.TableDTO;
import com.code.RestaurantReservationSystem.model.Tables;
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

    @GetMapping("/getAll/{restaurantId}")
    public ResponseEntity<List<Tables>> getTablesByRestaurant(@PathVariable Long restaurantId) {
        List<Tables> tables = tableService.getTablesByRestaurant(restaurantId);
        tables.forEach(table -> table.getRestaurant().getId()); 
        return ResponseEntity.ok(tables);
    }
}