package app.buildrun.agrosafe.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "burn_reports")
public class BurnReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID userId;

    // Dados meteorológicos
    private double averageTemperature;  // Temperatura média diária
    private double humidity;             // Umidade relativa do ar
    private double precipitation;        // Precipitação

    // Dados de solo e vegetação
    private double soilMoistureIndex;     // Índice de umidade do solo
    private double vegetationIndex;       // Índice de vegetação

    // Dados históricos de incêndio
    private String location;              // Localização
    private double burnedArea;            // Área queimada

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    // Construtores

    public BurnReport() {
    }

    public BurnReport(UUID userId, double averageTemperature, double humidity, double precipitation,
                      double soilMoistureIndex, double vegetationIndex,
                      String location, double burnedArea, LocalDateTime creationTimestamp) {
        this.userId = userId;
        this.averageTemperature = averageTemperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.soilMoistureIndex = soilMoistureIndex;
        this.vegetationIndex = vegetationIndex;
        this.location = location;
        this.creationTimestamp = creationTimestamp;
        this.burnedArea = burnedArea;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getSoilMoistureIndex() {
        return soilMoistureIndex;
    }

    public void setSoilMoistureIndex(double soilMoistureIndex) {
        this.soilMoistureIndex = soilMoistureIndex;
    }

    public double getVegetationIndex() {
        return vegetationIndex;
    }

    public void setVegetationIndex(double vegetationIndex) {
        this.vegetationIndex = vegetationIndex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public double getBurnedArea() {
        return burnedArea;
    }

    public void setBurnedArea(double burnedArea) {
        this.burnedArea = burnedArea;
    }
}
