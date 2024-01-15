package com.example.restapiservice.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UsersDto {
    Long id;
    String name;
    String userName;
    String email;
}
