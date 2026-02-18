package com.project.mup_vehicles.controllers;

import com.project.mup_vehicles.models.Vehicle;
import com.project.mup_vehicles.services.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return service.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/plate/{plateNumber}")
    public Vehicle getByPlate(@PathVariable String plateNumber) {
        return service.getVehicleByPlate(plateNumber);
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.createVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id, @RequestBody Vehicle updated) {
        return service.updateVehicle(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteVehicle(id);
    }

    @GetMapping("/{plate}/inspection")
    public Boolean checkInspection(@PathVariable String plate) {
        return service.getVehicleByPlate(plate).getInspectionValid();
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> getVehiclesByUser(@PathVariable Long userId) {
        return service.getVehiclesByUser(userId);
    }

    @PutMapping("/{plate}/owner/{newUserId}")
    public Vehicle transferOwnership(@PathVariable String plate, @PathVariable Long newUserId) {
        return service.transferOwnership(plate, newUserId);
    }

    @GetMapping("/stats/registered")
    public Long countRegistered() {
        return service.countRegisteredVehicles();
    }

    @GetMapping("/expired-inspection")
    public List<Vehicle> getExpiredInspectionVehicles() {
        return service.getExpiredInspectionVehicles();
    }
    @PutMapping("/{plate}/renew-registration")
    public Vehicle renewRegistration(@PathVariable String plate) {
        return service.renewRegistration(plate);
    }

}
