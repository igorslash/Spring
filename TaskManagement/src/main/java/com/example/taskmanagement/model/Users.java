package com.example.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "status", nullable = false)
    private String status;
}
