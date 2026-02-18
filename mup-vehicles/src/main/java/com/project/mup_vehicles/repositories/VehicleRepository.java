package com.project.mup_vehicles.repositories;


import com.project.mup_vehicles.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByPlateNumber(String plateNumber);
    List<Vehicle> findByOwnerId(Long userId);
    Long countByDeletedFalse();
    List<Vehicle> findByInspectionValidFalse();
}
