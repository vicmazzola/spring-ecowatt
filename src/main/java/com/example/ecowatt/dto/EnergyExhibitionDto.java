package com.example.ecowatt.dto;

import java.time.LocalDateTime;

/**
 * DTO used for exposing energy consumption records in API responses.
 */
public record EnergyExhibitionDto(
        Long id,
        String device,
        Double consumptionWatts,
        LocalDateTime timestamp
) {}
