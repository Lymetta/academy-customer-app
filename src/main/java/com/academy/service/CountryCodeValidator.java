package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.exception.ValidationException;

public class CountryCodeValidator extends Validator{
    @Override
    public void validate(Object t) {
        if (!t.toString().isBlank()) {
            try {
                CountryCode.valueOf(t.toString().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new ValidationException("Country code " + t + " is not valid");
            }
        }
    }
}
