package com.academy.service;

import com.academy.entity.Customer;
import com.academy.exception.ValidationException;

import javax.management.MalformedObjectNameException;

public class MandatoryCustomerValuesValidator extends Validator{
    @Override
    public void validate(Object customer) {

        if(customer instanceof Customer){
            if (((Customer) customer).getFirstName().isBlank()) {
                throw new ValidationException("First name is missing!");
            }
            if(((Customer) customer).getLastName().isBlank()) {
                throw new ValidationException("Last name is missing!");
            }
            if(((Customer) customer).getPersonalNumber().isBlank()) {
                throw new ValidationException("Personal code is missing!");
            }
        }


    }
}
