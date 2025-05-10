package com.example.ecowatt.service;

import com.example.ecowatt.dto.EnergyConsumptionDto;
import com.example.ecowatt.model.EnergyConsumption;
import com.example.ecowatt.repository.EnergyConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for handling business logic related to energy consumption records.
 */
@Service
public class EnergyConsumptionService {

    @Autowired
    private EnergyConsumptionRepository repository;

    /**
     * Saves a new energy consumption record to the database.
     *
     * @param dto the data transfer object containing the consumption info
     * @return the saved EnergyConsumption entity
     */
    public EnergyConsumption save(EnergyConsumptionDto dto) {
        EnergyConsumption consumption = new EnergyConsumption(
                dto.getDevice(),
                dto.getConsumptionWatts(),
                dto.getTimestamp()
        );
        return repository.save(consumption);
    }

    /**
     * Retrieves all energy consumption records.
     *
     * @return list of all EnergyConsumption entities
     */
    public List<EnergyConsumption> findAll() {
        return repository.findAll();
    }
}
