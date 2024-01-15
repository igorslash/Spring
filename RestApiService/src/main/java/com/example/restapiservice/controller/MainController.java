package com.example.restapiservice.controller;

import com.example.restapiservice.UsersService;
import com.example.restapiservice.dto.UsersDto;
import com.example.restapiservice.entity.Users;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "Users API")
@RestController
@AllArgsConstructor
@Slf4j
public class MainController {
    private final UsersService userService;

    @PostMapping("/api/users")
    @Operation(summary = "Create user")
    public void createUser(@RequestBody UsersDto usersDto) {
        userService.createUser(usersDto);
    }
    @Operation(summary = "Get all users")
    @GetMapping("/api/allUsers")
    public Iterable<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @Operation(summary = "Get user by id")
    @GetMapping("/api/user/{id}")
    public Users getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    @Operation(summary = "Delete user by id")
    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/api/user/{id}")
    @Operation(summary = "Update user by id")
    public Users updateUser(@PathVariable Long id,
                            @RequestBody Users users) {
        return userService.updateUser(id, users);
    }
    @GetMapping("/api/user/email")
    @Operation(summary = "Find user by email")
    public Users findUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }
}
