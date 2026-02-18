package com.project.mup_vehicles.repositories;

import com.project.mup_vehicles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByJmbg(String jmbg);
}
