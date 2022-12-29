package com.spring.mvc2.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckEmailEmailValidator implements ConstraintValidator<CheckEmail, String> {
    private String endOfEmail;
    @Override
    public void initialize(CheckEmail checkEmail) {
        endOfEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.endsWith(endOfEmail);
    }
}
