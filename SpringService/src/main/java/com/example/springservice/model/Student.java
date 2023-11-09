package com.example.springservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class Student {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private int age;
}
