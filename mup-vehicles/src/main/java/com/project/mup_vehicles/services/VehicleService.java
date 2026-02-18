package com.project.mup_vehicles.services;

import com.project.mup_vehicles.models.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle getVehicleByPlate(String plateNumber);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
    List<Vehicle> getVehiclesByUser(Long userId);
    Vehicle transferOwnership(String plateNumber, Long newUserId);
    Long countRegisteredVehicles();
    List<Vehicle> getExpiredInspectionVehicles();
    Vehicle renewRegistration(String plateNumber);

}
