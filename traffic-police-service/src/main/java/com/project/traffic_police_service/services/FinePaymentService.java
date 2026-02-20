package com.project.traffic_police_service.services;

import com.project.traffic_police_service.dto.FinePaymentRequestDTO;
import com.project.traffic_police_service.dto.FinePaymentResponseDTO;
import com.project.traffic_police_service.models.FinePayment;

import java.util.List;

public interface FinePaymentService {
    List<FinePayment> getAllPayments();
    FinePayment getPaymentById(Long id);
    FinePayment createPayment(FinePayment payment);
    FinePaymentResponseDTO updatePayment(Long id, FinePaymentRequestDTO dto);
    void deletePayment(Long id);
    FinePayment payFine(Long violationId, FinePayment payment);
}
