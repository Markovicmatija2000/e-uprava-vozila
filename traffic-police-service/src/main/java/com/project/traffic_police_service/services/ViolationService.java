package com.project.traffic_police_service.services;

import com.project.traffic_police_service.dto.DriverProfileDTO;
import com.project.traffic_police_service.models.Violation;

import java.util.List;

public interface ViolationService {
    List<Violation> getAllViolations();
    Violation getViolationById(Long id);
    Violation createViolation(Violation violation);
    Violation updateViolation(Long id, Violation violation);
    void deleteViolation(Long id);
    List<String> getTopOffenders();

    List<Violation> getViolationsByDriver(String jmbg);
    List<Violation> getUnpaidViolations();
    DriverProfileDTO getDriverProfile(String jmbg);
}
