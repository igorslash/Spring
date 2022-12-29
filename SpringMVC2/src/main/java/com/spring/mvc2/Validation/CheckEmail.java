package com.spring.mvc2.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//начало создания аннотации полей
@Retention(RetentionPolicy.RUNTIME)//сохраняет инфо до окончания кода
@Constraint(validatedBy = CheckEmailEmailValidator.class)
public @interface CheckEmail {
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    public Class<?>[]groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
