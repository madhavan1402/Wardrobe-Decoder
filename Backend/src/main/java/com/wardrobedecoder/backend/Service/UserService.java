package com.wardrobedecoder.backend.Service;

import com.wardrobedecoder.backend.Entity.UserEntity;
import com.wardrobedecoder.backend.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Create or Update User
    public UserEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepo.findById(id);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    // Get user by Email (custom query from UserRepo)
    public UserEntity getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
