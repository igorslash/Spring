package com.example.taskmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleException
            (UserNotFoundException userNotFoundException) {
        UserException userException = new UserException(
                userNotFoundException.getMessage(),
                userNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException,
                userException.getHttpStatus());
    }
    @ExceptionHandler(UserExistingEmailException.class)
    public ResponseEntity<Object> handleUserExistingEmailException
            (UserExistingEmailException userExistingEmailException) {
        UserException userException = new UserException(
                userExistingEmailException.getMessage(),
                userExistingEmailException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException,
                userException.getHttpStatus());
    }

}
