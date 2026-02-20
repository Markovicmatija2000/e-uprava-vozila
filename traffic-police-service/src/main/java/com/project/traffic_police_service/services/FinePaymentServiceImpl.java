package com.project.traffic_police_service.services;


import com.project.traffic_police_service.dto.FinePaymentRequestDTO;
import com.project.traffic_police_service.dto.FinePaymentResponseDTO;
import com.project.traffic_police_service.models.FinePayment;
import com.project.traffic_police_service.models.Violation;
import com.project.traffic_police_service.repositories.FinePaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinePaymentServiceImpl implements FinePaymentService {

    private final FinePaymentRepository repo;
    private final ViolationService violationService;

    public FinePaymentServiceImpl(FinePaymentRepository repo, ViolationService violationService)
    {
        this.repo = repo;
        this.violationService = violationService;
    }

    @Override
    public List<FinePayment> getAllPayments() {
        return repo.findAll();
    }

    @Override
    public FinePayment getPaymentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @Override
    public FinePayment createPayment(FinePayment payment) {
        return repo.save(payment);
    }

    @Override
    public FinePaymentResponseDTO updatePayment(Long id, FinePaymentRequestDTO dto) {
        FinePayment payment = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        Violation violation = violationService.getViolationById(dto.getViolationId());

        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setViolation(violation);

        FinePayment saved = repo.save(payment);

        FinePaymentResponseDTO dtoResponse = new FinePaymentResponseDTO();
        dtoResponse.setAmount(saved.getAmount());
        dtoResponse.setPaymentDate(saved.getPaymentDate());
        dtoResponse.setViolation(saved.getViolation());
        dtoResponse.setViolationPaid(saved.getViolation().getPaid());

        return dtoResponse;

    }


    @Override
    public void deletePayment(Long id) {
        repo.deleteById(id);
    }

    @Override
    public FinePayment payFine(Long violationId, FinePayment payment) {
        Violation violation = violationService.getViolationById(violationId);
        violation.setPaid(true);
        violationService.updateViolation(violationId, violation);

        payment.setViolation(violation);
        payment.setPaymentDate(LocalDate.now());
        return repo.save(payment);
    }

}
