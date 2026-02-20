package com.project.traffic_police_service.repositories;


import com.project.traffic_police_service.models.FinePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinePaymentRepository extends JpaRepository<FinePayment, Long> {
}
