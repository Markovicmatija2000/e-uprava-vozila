package com.project.traffic_police_service.controllers;


import com.project.traffic_police_service.dto.FinePaymentRequestDTO;
import com.project.traffic_police_service.dto.FinePaymentResponseDTO;
import com.project.traffic_police_service.models.FinePayment;
import com.project.traffic_police_service.services.FinePaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/traffic/payments")
public class FinePaymentController {

    private final FinePaymentService service;

    public FinePaymentController(FinePaymentService service) {
        this.service = service;
    }

    @GetMapping
    public List<FinePayment> getAll() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public FinePayment getById(@PathVariable Long id) {
        return service.getPaymentById(id);
    }

    @PostMapping
    public FinePayment create(@RequestBody FinePayment payment) {
        return service.createPayment(payment);
    }

    @PutMapping("/{id}")
    public FinePaymentResponseDTO update(@PathVariable Long id,
                                         @RequestBody FinePaymentRequestDTO updated) {
        return service.updatePayment(id, updated);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePayment(id);
    }

    @PostMapping("/pay/{violationId}")
    public FinePayment payFine(@PathVariable Long violationId, @RequestBody FinePayment payment) {
        // attach violation reference here
        return service.payFine(violationId,payment);
    }

}
