package com.example.flightapp.service;

import com.example.flightapp.entity.UserProfile;
import com.example.flightapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    public UserProfile getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}
