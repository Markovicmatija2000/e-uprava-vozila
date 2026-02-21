package com.project.e_goverment.services;



import com.project.e_goverment.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserByJmbg(String jmbg);
    Optional<User> isValid(String username, String password);
}

