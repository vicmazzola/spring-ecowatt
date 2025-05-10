package com.example.ecowatt.service;

import com.example.ecowatt.dto.EnergyConsumptionDto;
import com.example.ecowatt.dto.EnergyExhibitionDto;
import com.example.ecowatt.model.EnergyConsumption;
import com.example.ecowatt.repository.EnergyConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
     * @return the saved EnergyExhibitionDto with stored data
     */
    public EnergyExhibitionDto save(EnergyConsumptionDto dto) {
        EnergyConsumption consumption = new EnergyConsumption(
                dto.device(),
                dto.consumptionWatts(),
                dto.timestamp()
        );
        return toDto(repository.save(consumption));
    }

    /**
     * Retrieves all energy consumption records.
     *
     * @return list of all EnergyExhibitionDto objects
     */
    public List<EnergyExhibitionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing energy consumption record by ID.
     *
     * @param id  the ID of the record to update
     * @param dto the new values for the record
     * @return the updated EnergyExhibitionDto
     * @throws RuntimeException if the record is not found
     */
    public EnergyExhibitionDto update(Long id, EnergyConsumptionDto dto) {
        EnergyConsumption existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Energy consumption not found with id " + id));

        existing.setDevice(dto.device());
        existing.setConsumptionWatts(dto.consumptionWatts());
        existing.setTimestamp(dto.timestamp());

        return toDto(repository.save(existing));
    }

    /**
     * Deletes an energy consumption record by ID.
     *
     * @param id the ID of the record to delete
     * @throws RuntimeException if the record is not found
     */
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Energy consumption not found with id " + id);
        }
        repository.deleteById(id);
    }

    /**
     * Converts an EnergyConsumption entity to EnergyExhibitionDto.
     *
     * @param entity the EnergyConsumption entity
     * @return the converted EnergyExhibitionDto
     */
    private EnergyExhibitionDto toDto(EnergyConsumption entity) {
        return new EnergyExhibitionDto(
                entity.getId(),
                entity.getDevice(),
                entity.getConsumptionWatts(),
                entity.getTimestamp()
        );
    }
}
