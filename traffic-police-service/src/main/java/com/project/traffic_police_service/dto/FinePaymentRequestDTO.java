package com.project.traffic_police_service.dto;


import lombok.Data;

import java.time.LocalDate;


public class FinePaymentRequestDTO {
    private Double amount;
    private LocalDate paymentDate;
    private Long violationId;

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

    public Long getViolationId() {
        return violationId;
    }

    public void setViolationId(Long violationId) {
        this.violationId = violationId;
    }
}
