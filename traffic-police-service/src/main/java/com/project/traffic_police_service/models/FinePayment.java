package com.project.traffic_police_service.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "fine_payments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate paymentDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "violation_id", nullable = false)
    private Violation violation;

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Violation getViolation() {
        return violation;
    }

    public void setViolation(Violation violation) {
        this.violation = violation;
    }
}
