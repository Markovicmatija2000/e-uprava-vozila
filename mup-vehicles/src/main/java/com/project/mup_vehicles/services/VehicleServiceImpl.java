package com.project.mup_vehicles.services;

import com.project.mup_vehicles.models.User;
import com.project.mup_vehicles.models.Vehicle;
import com.project.mup_vehicles.repositories.UserRepository;
import com.project.mup_vehicles.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;
    private final UserRepository userRepo; // needed for ownership transfer

    public VehicleServiceImpl(VehicleRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
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
        Vehicle v = getVehicleById(id);
        v.setPlateNumber(updated.getPlateNumber());
        v.setBrand(updated.getBrand());
        v.setModel(updated.getModel());
        v.setYear(updated.getYear());
        v.setInspectionValid(updated.getInspectionValid());
        v.setDeleted(updated.getDeleted());
        v.setOwner(updated.getOwner());
        v.setRegistrationFrom(updated.getRegistrationFrom());
        v.setRegistrationTo(updated.getRegistrationTo());
        return repo.save(v);
    }

    @Override
    public void deleteVehicle(Long id) {
        repo.deleteById(id);
    }

    // Extra methods
    @Override
    public List<Vehicle> getVehiclesByUser(Long userId) {
        return repo.findByOwnerId(userId);
    }

    @Override
    public Vehicle transferOwnership(String plateNumber, Long newUserId) {
        Vehicle v = getVehicleByPlate(plateNumber);
        User newOwner = userRepo.findById(newUserId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + newUserId));
        v.setOwner(newOwner);
        return repo.save(v);
    }

    @Override
    public Long countRegisteredVehicles() {
        return repo.countByDeletedFalse();
    }

    @Override
    public List<Vehicle> getExpiredInspectionVehicles() {
        return repo.findByInspectionValidFalse();
    }
    @Override
    public Vehicle renewRegistration(String plateNumber) {
        Vehicle v = getVehicleByPlate(plateNumber);
        v.setRegistrationFrom(LocalDate.now());
        v.setRegistrationTo(LocalDate.now().plusYears(1));
        return repo.save(v);
    }

}
