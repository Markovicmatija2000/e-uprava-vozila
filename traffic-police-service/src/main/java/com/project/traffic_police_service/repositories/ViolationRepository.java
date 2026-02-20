package com.project.traffic_police_service.repositories;


import com.project.traffic_police_service.models.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
    List<Violation> findByDriverJmbg(String driverJmbg);
    List<Violation> findByPaidFalse();
    @Query("SELECT v.driverJmbg, COUNT(v) as cnt " +
            "FROM Violation v " +
            "GROUP BY v.driverJmbg " +
            "ORDER BY cnt DESC")
    List<Object[]> findTopOffenders();

}



