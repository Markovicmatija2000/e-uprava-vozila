package com.project.traffic_police_service.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "traffic_violations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate date;
    private Double fineAmount;
    private Boolean paid;

    // Reference to user in MUP service (by JMBG)
    private String driverJmbg;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getDriverJmbg() {
        return driverJmbg;
    }

    public void setDriverJmbg(String driverJmbg) {
        this.driverJmbg = driverJmbg;
    }
}
