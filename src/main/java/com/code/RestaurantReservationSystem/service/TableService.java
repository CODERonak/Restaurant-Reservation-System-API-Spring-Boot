package com.code.RestaurantReservationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Table.TableDTO;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.model.Tables;
import com.code.RestaurantReservationSystem.repository.TableRepository;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public void createTable(TableDTO request) {
        Tables table = new Tables();
        table.setTableNumber(request.getTableNumber());
        table.setCapacity(request.getCapacity());
        table.setStatus(request.getStatus());

        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getRestaurantId());
        table.setRestaurant(restaurant);

        tableRepository.save(table);
    }

    public void updateTable(Long tableId, TableDTO request) {
        Tables existingTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new RuntimeException("Table not found with id: " + tableId));

        existingTable.setTableNumber(request.getTableNumber());
        existingTable.setCapacity(request.getCapacity());
        existingTable.setStatus(request.getStatus());

        tableRepository.save(existingTable);
    }

    public List<Tables> getTablesByRestaurant(Long restaurantId) {
        List<Tables> tables = tableRepository.findByRestaurantId(restaurantId);
        tables.forEach(table -> table.getRestaurant().getId()); 
        return tables;
    }
}