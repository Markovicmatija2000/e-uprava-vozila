package com.project.traffic_police_service.controllers;

import com.project.traffic_police_service.models.Violation;
import com.project.traffic_police_service.services.ViolationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic/violations")
public class ViolationController {

    private final ViolationService service;

    public ViolationController(ViolationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Violation> getAll() {
        return service.getAllViolations();
    }

    @GetMapping("/{id}")
    public Violation getById(@PathVariable Long id) {
        return service.getViolationById(id);
    }

    @PostMapping
    public Violation create(@RequestBody Violation violation) {
        return service.createViolation(violation);
    }

    @PutMapping("/{id}")
    public Violation update(@PathVariable Long id, @RequestBody Violation updated) {
        return service.updateViolation(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteViolation(id);
    }

    @GetMapping("/driver/{jmbg}")
    public List<Violation> getByDriver(@PathVariable String jmbg) {
        return service.getViolationsByDriver(jmbg);
    }

    @GetMapping("/unpaid")
    public List<Violation> getUnpaid() {
        return service.getUnpaidViolations();
    }

    @PostMapping("/register")
    public Violation registerViolation(@RequestBody Violation violation) {
        return service.createViolation(violation);
    }

    @GetMapping("/stats/top-offenders")
    public List<String> getTopOffenders() {
        return service.getTopOffenders();
    }
}
