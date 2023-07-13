package com.example.microservicespring.service;

import com.example.microservicespring.model.CustomersDto;

public interface CustomerService {
    void addCustomer(int id, String name);
    CustomersDto getCustomers(int id);
}
