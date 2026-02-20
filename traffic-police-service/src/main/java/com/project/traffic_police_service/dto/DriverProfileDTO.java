package com.project.traffic_police_service.dto;

import com.project.traffic_police_service.models.Violation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DriverProfileDTO {
    private UserDTO driver;
    private List<Violation> violations;
    private List<FinePaymentResponseDTO> payments;

    public UserDTO getDriver() {
        return driver;
    }

    public void setDriver(UserDTO driver) {
        this.driver = driver;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    public List<FinePaymentResponseDTO> getPayments() {
        return payments;
    }

    public void setPayments(List<FinePaymentResponseDTO> payments) {
        this.payments = payments;
    }
}

