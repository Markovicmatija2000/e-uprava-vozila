package com.project.e_goverment.repositories;


import com.project.e_goverment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByJmbg(String jmbg);
    Optional<User> findByEmailAndPassword(String email, String password);

}
