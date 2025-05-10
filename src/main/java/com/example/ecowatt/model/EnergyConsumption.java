package com.example.ecowatt.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a record of energy consumption from a specific device.
 * Each entry includes the device name, the amount of energy consumed in watts,
 * and the timestamp of the reading.
 */
@Entity
@Table(name = "tb_energy_consumption")
public class EnergyConsumption {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ENERGY_SEQ"
    )
    @SequenceGenerator(
            name = "ENERGY_SEQ",
            sequenceName = "ENERGY_SEQ",
            allocationSize = 1
    )
    private Long id;

    private String device;

    @Column(name = "consumption_watts")
    private Double consumptionWatts;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    /**
     * Default constructor required by JPA.
     */
    public EnergyConsumption() {}

    /**
     * All-args constructor to create a new energy consumption record.
     *
     * @param device the name of the device
     * @param consumptionWatts the energy consumed in watts
     * @param timestamp the time when the consumption was recorded
     */
    public EnergyConsumption(String device, Double consumptionWatts, LocalDateTime timestamp) {
        this.device = device;
        this.consumptionWatts = consumptionWatts;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnergyConsumption)) return false;
        EnergyConsumption that = (EnergyConsumption) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(device, that.device) &&
                Objects.equals(consumptionWatts, that.consumptionWatts) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, device, consumptionWatts, timestamp);
    }
}
