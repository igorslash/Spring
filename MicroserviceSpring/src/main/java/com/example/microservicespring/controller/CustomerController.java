package com.example.microservicespring.controller;

import com.example.microservicespring.model.CustomersDto;
import com.example.microservicespring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @PostMapping
    public void addCustomer
            (@RequestParam int id, @RequestParam String name) {
        customerService.addCustomer(id, name);
    }
    @GetMapping
    public CustomersDto getCustomers(@RequestParam int id) {
        return customerService.getCustomers(id);
    }
}
