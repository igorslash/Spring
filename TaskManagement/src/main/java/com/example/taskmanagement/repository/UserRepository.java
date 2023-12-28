package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long id);

    Optional<Object> findByEmail(String email);
}
