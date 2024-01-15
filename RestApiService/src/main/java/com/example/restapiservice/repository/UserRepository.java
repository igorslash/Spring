package com.example.restapiservice.repository;

import com.example.restapiservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users WHERE email = :email",
            nativeQuery = true)
    Users findUserByEmail(@Param("email") String email);
}
