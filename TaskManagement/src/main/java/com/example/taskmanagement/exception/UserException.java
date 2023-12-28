package com.example.taskmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
public class UserException {
    private String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
