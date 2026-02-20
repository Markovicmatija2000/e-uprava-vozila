package com.project.mup_vehicles.dtos;


import com.project.mup_vehicles.models.Vehicle;
import java.util.List;

public class VehicleWithViolationsDTO {
    private Vehicle vehicle;
    private List<ViolationDTO> ownerViolations;

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<ViolationDTO> getOwnerViolations() {
        return ownerViolations;
    }
    public void setOwnerViolations(List<ViolationDTO> ownerViolations) {
        this.ownerViolations = ownerViolations;
    }
}
