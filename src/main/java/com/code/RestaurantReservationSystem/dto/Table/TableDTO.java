package com.code.RestaurantReservationSystem.dto.Table;

import com.code.RestaurantReservationSystem.enums.Enums.TableStatus;

import jakarta.validation.constraints.*;
import lombok.Data;

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