package com.academy.service;


import com.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator{
    @Override
    public void validate(Object t) {
        if((int)t<18 && (int)t!=0){
            throw new ValidationException("Customer is not an adult, age is" + t);
        }
    }
}
