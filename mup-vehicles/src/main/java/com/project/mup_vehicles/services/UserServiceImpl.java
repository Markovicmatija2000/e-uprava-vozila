package com.project.mup_vehicles.services;

import com.project.mup_vehicles.models.User;
import com.project.mup_vehicles.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public User updateUser(Long id, User updated) {
        User u = repo.findById(id).orElseThrow(() ->
                new RuntimeException("User not found with id: " + id));
        u.setName(updated.getName());
        u.setSurname(updated.getSurname());
        u.setAddress(updated.getAddress());
        u.setPhone(updated.getPhone());
        u.setEmail(updated.getEmail());
        u.setRole(updated.getRole());
        return repo.save(u);
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
    @Override
    public User getUserByJmbg(String jmbg) { return repo.findByJmbg(jmbg) .orElseThrow(() -> new RuntimeException("User not found with JMBG: " + jmbg)); }
}
