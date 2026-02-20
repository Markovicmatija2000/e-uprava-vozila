package com.project.traffic_police_service.repositories;


import com.project.traffic_police_service.models.FinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FinePaymentRepository extends JpaRepository<FinePayment, Long> {
    @Query("SELECT fp FROM FinePayment fp WHERE fp.violation.driverJmbg = :jmbg")
    List<FinePayment> findByDriverJmbg(@Param("jmbg") String jmbg);
}
