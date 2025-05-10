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
                dto.device(),
                dto.consumptionWatts(),
                dto.timestamp()
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

    /**
     * Updates an existing energy consumption record by ID.
     *
     * @param id  the ID of the record to update
     * @param dto the new values for the record
     * @return the updated EnergyConsumption entity
     * @throws RuntimeException if the record is not found
     */
    public EnergyConsumption update(Long id, EnergyConsumptionDto dto) {
        EnergyConsumption existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Energy consumption not found with id " + id));

        existing.setDevice(dto.device());
        existing.setConsumptionWatts(dto.consumptionWatts());
        existing.setTimestamp(dto.timestamp());

        return repository.save(existing);
    }
}
