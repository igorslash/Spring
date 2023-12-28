package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Users;
import com.example.taskmanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class Controller {
    UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId) {
        return userService.findById(Long.parseLong(userId));
    }
    @PostMapping
    public long addUser(@RequestBody Users user) {
        return userService.saveUser(user).getStatusCode().value();
    }
    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String userId)
            throws Exception {
        return userService.updateUser(Long.parseLong(userId));
    }
    @PostMapping("/deleteUser")
    public void deleteUser() {
        userService.deleteUser(1L);
    }
}
