package com.code.RestaurantReservationSystem.dto.Table;

import com.code.RestaurantReservationSystem.enums.Enums.TableStatus;

import jakarta.validation.constraints.*;
import lombok.Data;

// created the DTO for the table request can be sent to the server with validations
@Data
public class TableDTO {
    private long id;

    @NotNull
    @Min(value = 1)
    private Integer tableNumber;

    @NotNull
    @Min(value = 1)
    private Integer capacity;

    @NotNull
    private TableStatus status;

    @NotNull
    private Long restaurantId;
}