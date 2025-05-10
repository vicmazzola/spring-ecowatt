package com.example.ecowatt.controller;

import com.example.ecowatt.dto.EnergyConsumptionDto;
import com.example.ecowatt.model.EnergyConsumption;
import com.example.ecowatt.service.EnergyConsumptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing energy consumption records.
 */
@RestController
@RequestMapping("/api/energy")
public class EnergyConsumptionController {

    @Autowired
    private EnergyConsumptionService service;

    /**
     * Saves a new energy consumption record.
     *
     * @param dto the DTO with energy consumption data
     * @return the saved entity
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnergyConsumption save(@RequestBody @Valid EnergyConsumptionDto dto) {
        return service.save(dto);
    }

    /**
     * Returns all energy consumption records.
     *
     * @return list of EnergyConsumption
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnergyConsumption> findAll() {
        return service.findAll();
    }

    /**
     * Updates an existing energy consumption record by ID.
     *
     * @param id  the ID of the record to update
     * @param dto the updated energy consumption data
     * @return the updated entity
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnergyConsumption update(@PathVariable Long id, @RequestBody @Valid EnergyConsumptionDto dto) {
        return service.update(id, dto);
    }


}
