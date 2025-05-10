package com.example.ecowatt.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * DTO used for creating or receiving energy consumption records from the API.
 */
public class EnergyConsumptionDto {

    @NotBlank(message = "Device name is required")
    private String device;

    @NotNull(message = "Consumption value is required")
    @Min(value = 0, message = "Consumption must be greater than or equal to 0")
    private Double consumptionWatts;

    @NotNull(message = "Timestamp is required")
    private LocalDateTime timestamp;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Double getConsumptionWatts() {
        return consumptionWatts;
    }

    public void setConsumptionWatts(Double consumptionWatts) {
        this.consumptionWatts = consumptionWatts;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
