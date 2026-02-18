package com.project.mup_vehicles.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    private Integer year;

    private Boolean inspectionValid;

    private Boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    private LocalDate registrationFrom;
    private LocalDate registrationTo;
    public boolean isRegistrationValid()
    {
        return registrationTo != null && registrationTo.isAfter(LocalDate.now());
    }

    public LocalDate getRegistrationFrom() {
        return registrationFrom;
    }

    public void setRegistrationFrom(LocalDate registrationFrom) {
        this.registrationFrom = registrationFrom;
    }

    public LocalDate getRegistrationTo() {
        return registrationTo;
    }

    public void setRegistrationTo(LocalDate registrationTo) {
        this.registrationTo = registrationTo;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getInspectionValid() {
        return inspectionValid;
    }

    public void setInspectionValid(Boolean inspectionValid) {
        this.inspectionValid = inspectionValid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
