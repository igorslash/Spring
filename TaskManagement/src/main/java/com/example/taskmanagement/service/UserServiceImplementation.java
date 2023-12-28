package com.example.taskmanagement.service;

import com.example.taskmanagement.exception.UserExistingEmailException;
import com.example.taskmanagement.exception.UserNotFoundException;
import com.example.taskmanagement.model.Users;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.response.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    UserRepository userRepository;
    @Override
    public ResponseEntity<Object> saveUser(Users user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistingEmailException("User with email "
                    + user.getEmail()
                    + " already exists");

        }
        userRepository.save(user);
        return ResponseHandler
                .responseBuilder("user created successfully",
                HttpStatus.OK, findById(user.getId()));
    }

    @Override
    public ResponseEntity<Object> findById(long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User with id " + id
                    + " not found");
        }
        return ResponseHandler
                .responseBuilder("user found",
                        HttpStatus.OK, userRepository.findById(id));
    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {
        Users user = userRepository.findById(id).get();
        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", user.getId().toString());
        updateResponse.put("previous status", user.getStatus());
        if (user.getStatus().equalsIgnoreCase("offline")) {
            user.setStatus("active");
        }else {
            user.setStatus("offline");
            updateResponse.put("current status", user.getStatus());
            user.setStatus("active");
            updateResponse.put("current status", user.getStatus());
        }
        userRepository.save(user);
        return ResponseHandler
                .responseBuilder("User updated successfully",
                        HttpStatus.OK, updateResponse);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
