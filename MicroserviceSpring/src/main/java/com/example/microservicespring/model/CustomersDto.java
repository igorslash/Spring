package com.example.microservicespring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomersDto {
    private int id;
    private String name;
}
