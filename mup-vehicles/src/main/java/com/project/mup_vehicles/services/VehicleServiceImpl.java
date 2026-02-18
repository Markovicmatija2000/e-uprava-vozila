package com.project.mup_vehicles.services;

import com.project.mup_vehicles.models.Vehicle;
import com.project.mup_vehicles.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
    }

    @Override
    public Vehicle getVehicleByPlate(String plateNumber) {
        return repo.findByPlateNumber(plateNumber)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with plate: " + plateNumber));
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle updated) {
        Vehicle v = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        v.setPlateNumber(updated.getPlateNumber());
        v.setBrand(updated.getBrand());
        v.setModel(updated.getModel());
        v.setYear(updated.getYear());
        v.setInspectionValid(updated.getInspectionValid());
        v.setDeleted(updated.getDeleted());
        v.setOwner(updated.getOwner());
        return repo.save(v);
    }

    @Override
    public void deleteVehicle(Long id) {
        repo.deleteById(id);
    }
}
