package com.project.traffic_police_service.dto;

import com.project.traffic_police_service.models.Violation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
public class FinePaymentResponseDTO {
    private Double amount;
    private LocalDate paymentDate;
    private Violation violation;
    private Boolean violationPaid;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }

    public void setViolationPaid(Boolean violationPaid) {
        this.violationPaid = violationPaid;
    }

    public Boolean getViolationPaid() {
        return violationPaid;
    }

}
