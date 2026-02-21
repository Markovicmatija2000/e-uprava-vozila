package com.project.e_goverment.services;

import com.project.e_goverment.models.User;
import com.project.e_goverment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> isValid(String username, String password)
    {
        return repo.findByEmailAndPassword(username, password);
    }
}
