package com.example.flightapp.repository;

import com.example.flightapp.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, String> {
    Optional<UserProfile> findByUsername(String username);
}
