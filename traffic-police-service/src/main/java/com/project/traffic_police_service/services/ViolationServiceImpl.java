package com.project.traffic_police_service.services;

import com.project.traffic_police_service.dto.UserDTO;
import com.project.traffic_police_service.models.Violation;
import com.project.traffic_police_service.repositories.ViolationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationServiceImpl implements ViolationService {

    private final ViolationRepository repo;
    private final VehicleClient vehicleClient;

    public ViolationServiceImpl(ViolationRepository repo,VehicleClient vehicleClient)
    {
        this.repo = repo;
        this.vehicleClient = vehicleClient;
    }

    @Override
    public List<Violation> getAllViolations() {
        return repo.findAll();
    }

    @Override
    public Violation getViolationById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found with id: " + id));
    }

    @Override
    public Violation createViolation(Violation violation)
    {
        UserDTO user;
        try {
            user = vehicleClient.getUserByJmbg(violation.getDriverJmbg());
        } catch (Exception e) {
            throw new RuntimeException("Driver not found in Vehicle Service: " + violation.getDriverJmbg(), e);
        }
        violation.setDriverJmbg(user.getJmbg());

        return repo.save(violation);
    }

    @Override
    public Violation updateViolation(Long id, Violation updated) {

        UserDTO user;
        Violation v = getViolationById(id);
        v.setDescription(updated.getDescription());
        v.setDate(updated.getDate());
        v.setFineAmount(updated.getFineAmount());
        v.setPaid(updated.getPaid());
        try {
            user = vehicleClient.getUserByJmbg(updated.getDriverJmbg());
        } catch (Exception e) {
            throw new RuntimeException("Driver not found in Vehicle Service: " + updated.getDriverJmbg(), e);
        }

        v.setDriverJmbg(user.getJmbg());
        return repo.save(v);
    }

    @Override
    public void deleteViolation(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Violation> getViolationsByDriver(String jmbg) {
        return repo.findByDriverJmbg(jmbg);
    }

    @Override
    public List<Violation> getUnpaidViolations() {
        return repo.findByPaidFalse();
    }

    @Override
    public List<String> getTopOffenders() {
        return repo.findTopOffenders().stream()
                .map(row -> (String) row[0])
                .limit(5)
                .toList();
    }
}
