package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BanWordValidator.class)
public @interface BanWordsValidation {
    String message() default "Обнаружена нецензурная лексика";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
