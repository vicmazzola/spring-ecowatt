package com.example.ecowatt.repository;

import com.example.ecowatt.model.EnergyConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link EnergyConsumption} entity.
 * Provides CRUD operations and database interaction using Spring Data JPA.
 */
public interface EnergyConsumptionRepository extends JpaRepository<EnergyConsumption, Long> {
    // Custom queries (if needed) will go here
}
