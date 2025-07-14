package com.code.RestaurantReservationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Table.TableDTO;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.model.Tables;
import com.code.RestaurantReservationSystem.repository.TableRepository;

// this service is used to create, update and lists a table in the database
@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    // this method is used to create a table in the database
    public void createTable(TableDTO request) {
        // create's a new table and restaurant object and saves it in the database
        Tables table = new Tables();
        Restaurant restaurant = new Restaurant();

        // sets the values of the table and restaurant objects
        restaurant.setId(request.getRestaurantId());
        table.setTableNumber(request.getTableNumber());
        table.setCapacity(request.getCapacity());
        table.setStatus(request.getStatus());
        table.setRestaurant(restaurant);

        tableRepository.save(table);
    }

    // this method is used to update a table in the database
    public void updateTable(Long tableId, TableDTO request) {
        // finds the table in the database and updates it with the new values
        Tables existingTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + tableId));

        existingTable.setTableNumber(request.getTableNumber());
        existingTable.setCapacity(request.getCapacity());
        existingTable.setStatus(request.getStatus());

        tableRepository.save(existingTable);
    }

    // this method is used to list all the tables in the database
    public List<Tables> getTablesByRestaurant(Long restaurantId) {
        List<Tables> tables = tableRepository.findByRestaurantId(restaurantId);
        tables.forEach(table -> table.getRestaurant().getId());
        return tables;
    }
}