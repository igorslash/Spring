package com.example.microservicespring.service.impl;

import com.example.microservicespring.model.CustomersDto;
import com.example.microservicespring.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CustomerServiceMemoryImpl implements CustomerService {
    Map<Integer, CustomersDto> persist = new HashMap<>();
    @Override
    public void addCustomer(int id, String name) {
        persist.put(id, new CustomersDto(id, name));
    }

    @Override
    public CustomersDto getCustomers(int id) {
        return persist.get(id);
    }
}
