package com.example.ecowatt.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * DTO used for creating or receiving energy consumption records from the API.
 */
public record EnergyConsumptionDto(

        @NotBlank(message = "Device name is required")
        String device,

        @NotNull(message = "Consumption value is required")
        @Min(value = 0, message = "Consumption must be greater than or equal to 0")
        Double consumptionWatts,

        @NotNull(message = "Timestamp is required")
        LocalDateTime timestamp

) {}
