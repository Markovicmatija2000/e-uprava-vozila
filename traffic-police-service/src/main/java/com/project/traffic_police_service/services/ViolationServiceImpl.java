package com.project.traffic_police_service.services;

import com.project.traffic_police_service.models.Violation;
import com.project.traffic_police_service.repositories.ViolationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationServiceImpl implements ViolationService {

    private final ViolationRepository repo;

    public ViolationServiceImpl(ViolationRepository repo) {
        this.repo = repo;
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
    public Violation createViolation(Violation violation) {
        return repo.save(violation);
    }

    @Override
    public Violation updateViolation(Long id, Violation updated) {
        Violation v = getViolationById(id);
        v.setDescription(updated.getDescription());
        v.setDate(updated.getDate());
        v.setFineAmount(updated.getFineAmount());
        v.setPaid(updated.getPaid());
        v.setDriverJmbg(updated.getDriverJmbg());
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
