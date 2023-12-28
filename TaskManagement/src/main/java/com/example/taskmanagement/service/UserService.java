package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<Object> saveUser(Users user);
    ResponseEntity<Object> findById(long id);
    ResponseEntity<Object> updateUser(long id) throws Exception;

    void deleteUser(long id);
}
