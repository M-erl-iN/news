package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.demo.api.fetcher.BanWordsMatcher;

@Component
@RequiredArgsConstructor
public class BanWordValidator implements ConstraintValidator<BanWordsValidation, Object> {

    private final BanWordsMatcher banWordsMatcher;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return banWordsMatcher.match(value.toString());
    }
}