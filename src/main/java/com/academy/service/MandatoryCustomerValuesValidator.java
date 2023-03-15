package com.academy.service;

import com.academy.exception.ValidationException;

import javax.management.MalformedObjectNameException;

public class MandatoryCustomerValuesValidator extends Validator{
    @Override
    public void validate(Object t) {
        if (t.toString().isBlank()) {
            throw new ValidationException("Not all required fields entered");
        }

    }
}
